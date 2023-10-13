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
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

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
                String algoritmo = reader.readLine();

                // Verifica que tanto el mensaje como la clave no sean nulos
                if (mensaje != null && clave != null && algoritmo != null) {

                    switch (algoritmo) {
                        case "DES": {
                            String mensajedesCifrado = DESdeCipher(clave, mensaje);
                            // Muestra el mensaje descifrado y cifrado en las áreas de texto correspondientes
                            chatArea.append(user + "(" + algoritmo + ")" + ": " + mensajedesCifrado + "\n");
                            cipherArea.append(user + "(" + algoritmo + ")" + ": " + mensaje + "\n");

                            break;
                        }
                        case "AES": {
                            String mensajedesCifrado = AESdeCipher(clave, mensaje);
                            // Muestra el mensaje descifrado y cifrado en las áreas de texto correspondientes
                            chatArea.append(user + "(" + algoritmo + ")" + ": " + mensajedesCifrado + "\n");
                            cipherArea.append(user + "(" + algoritmo + ")" + ": " + mensaje + "\n");

                            break;
                        }
                        case "TDES": {
                            String mensajedesCifrado = TDESdeCipher(clave, mensaje);
                            // Muestra el mensaje descifrado y cifrado en las áreas de texto correspondientes
                            chatArea.append(user + "(" + algoritmo + ")" + ": " + mensajedesCifrado + "\n");
                            cipherArea.append(user + "(" + algoritmo + ")" + ": " + mensaje + "\n");
                            break;
                        }
                        default:
                            break;
                    }
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
        } catch (IOException ex) {
            // Ocurrió un error relacionado con la E/S o la criptografía, imprime la traza
            JOptionPane.showMessageDialog(null, "Ocurrió un error durante la operación: " + ex);
        }
    }

    public void sendMessage(String message, String key, String algoritmo) {
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println(message);
            writer.println(key);
            writer.println(algoritmo);
        } catch (IOException e) {
        }
    }

    private String DESdeCipher(String llave, String mensajeCifrado) {
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
            DESKeySpec kspec = new DESKeySpec(llave.getBytes());

            SecretKey ks = skf.generateSecret(kspec);

            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, ks);

            byte[] inputBytes = Base64.getDecoder().decode(mensajeCifrado);
            byte[] outputBytes = cipher.doFinal(inputBytes);

            return new String(outputBytes, StandardCharsets.UTF_8);
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException
                | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error durante la operación: " + e);
        }
        return null;
    }

    private String AESdeCipher(String llave, String mensajeCifrado) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(llave.getBytes(StandardCharsets.UTF_8), "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);

            byte[] inputBytes = Base64.getDecoder().decode(mensajeCifrado);
            byte[] outputBytes = cipher.doFinal(inputBytes);

            return new String(outputBytes, StandardCharsets.UTF_8);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
                | IllegalBlockSizeException | BadPaddingException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error durante la operación: " + e);
        }
        return null;
    }

    private String TDESdeCipher(String llave, String mensajeCifrado) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(llave.getBytes(StandardCharsets.UTF_8), "DESede");

            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);

            byte[] inputBytes = Base64.getDecoder().decode(mensajeCifrado);
            byte[] outputBytes = cipher.doFinal(inputBytes);

            return new String(outputBytes, StandardCharsets.UTF_8);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
                | IllegalBlockSizeException | BadPaddingException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error durante la operación: " + e);
        }
        return null;
    }

    public void stopCom() {
        isRunning = false;
    }
}
