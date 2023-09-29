package chat_socket;

/*	
  *
   *
    *
     *
      *
       *
        *
         *
          *
           *
      * * * *
       *
        *
      noripan
          *
           *
      * * * *
       *
        *
         *
          *
           *
            *
             *
              *
               *
                */

import java.io.*;
import java.net.*;
import javax.swing.JTextArea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class ChatPeer extends Thread {

    private final Socket socket;
    private final JTextArea chatArea;
    private final JTextArea cipherArea;
    private final String user;
    private volatile boolean isRunning = true;
    private ChatDisconnectListener disconnectListener;

    public ChatPeer(Socket socket, JTextArea chatArea, String usuario, JTextArea cipherArea) {
        this.socket = socket;
        this.chatArea = chatArea;
        this.cipherArea = cipherArea;
        user = usuario;
    }

    public void setDisconnectListener(ChatDisconnectListener listener) {
        this.disconnectListener = listener;
    }

    @Override
    public void run() {
        try {
            // Establece un lector para recibir datos del socket
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (isRunning) {
                // Lee el mensaje cifrado y la clave de cifrado del socket
                String mensaje = reader.readLine();
                String clave = reader.readLine();

                // Verifica que tanto el mensaje como la clave no sean nulos
                if (mensaje != null && clave != null) {
                    // Convierte la clave en bytes y genera la clave secreta
                    SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
                    DESKeySpec kspec = new DESKeySpec(clave.getBytes());
                    SecretKey ks = skf.generateSecret(kspec);

                    // Configura el cifrado con la clave secreta y modo de descifrado
                    Cipher cipher = Cipher.getInstance("DES");
                    cipher.init(Cipher.DECRYPT_MODE, ks);

                    // Decodifica el mensaje cifrado en bytes y lo descifra
                    byte[] inputBytes = Base64.getDecoder().decode(mensaje);
                    byte[] decryptedBytes = cipher.doFinal(inputBytes);
                    String mensajeDescifrado = new String(decryptedBytes, StandardCharsets.UTF_8);

                    // Muestra el mensaje descifrado y cifrado en las áreas de texto correspondientes
                    chatArea.append(user + ": " + mensajeDescifrado + "\n");
                    cipherArea.append(user + ": " + mensaje + "\n");
                }
            }
        } catch (SocketException e) {
            if (!isRunning) {
                // El socket se cerró de manera controlada
                System.out.println("Socket cerrado de manera controlada." + e);
            } else {
                // El socket se cerró inesperadamente, notifica al oyente de desconexión
                System.err.println("Socket cerrado inesperadamente." + e);
                if (disconnectListener != null) {
                    disconnectListener.onDisconnect();
                }
            }
        } catch (IOException | NoSuchAlgorithmException | InvalidKeyException | InvalidKeySpecException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
            // Ocurrió un error relacionado con la E/S o la criptografía, imprime la traza
            ex.printStackTrace();
        }
    }

    public void sendMessage(String message, String key) {
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println(message);
            writer.println(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopCom() {
        isRunning = false;
    }
}