package chat_socket;

import java.io.*;
import java.net.*;
import javax.swing.JTextArea;

public class ChatPeer extends Thread {

    private final Socket socket;
    private final JTextArea chatArea;
    private final String usuario;
    private volatile boolean isRunning = true;
    private ChatDisconnectListener disconnectListener;

    public ChatPeer(Socket socket, JTextArea chatArea, String usuario) {
        this.socket = socket;
        this.chatArea = chatArea;
        this.usuario = usuario;
    }

    public void setDisconnectListener(ChatDisconnectListener listener) {
        this.disconnectListener = listener;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message;

            while (isRunning && (message = reader.readLine()) != null) {
                chatArea.append(usuario + ": " + message + "\n");
            }
        } catch (SocketException e) {
            if (!isRunning) {
                // El socket se cerró de manera controlada (por ejemplo, cuando el usuario se desconecta)
                System.out.println("Socket cerrado de manera controlada.");
            } else {
                // El socket se cerró de manera inesperada (por ejemplo, cuando el cliente se desconecta)
                System.err.println("Socket cerrado de manera inesperada.");
                // Notificar a la ventana principal de chat sobre la desconexión
                if (disconnectListener != null) {
                    disconnectListener.onDisconnect();
                }
            }
        } catch (IOException e) {
            // Otras excepciones de E/S
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopCom() {
        isRunning = false;
    }
}
