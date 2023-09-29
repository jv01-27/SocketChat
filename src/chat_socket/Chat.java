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
                
import java.net.ServerSocket;
import java.io.*;
import java.net.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Chat extends javax.swing.JFrame implements ChatDisconnectListener {

    TextFieldEvent correction = new TextFieldEvent();
    private ServerSocket serverSocket;
    private Socket socket;
    private ChatPeer chatPeer;

    int xMouse, yMouse;

    public Chat(ServerSocket serverSocket, String user) {
        initComponents();
        //this.serverSocket = serverSocket;

        // Establecer la lógica para aceptar conexiones entrantes como servidor
        try {
            socket = serverSocket.accept(); // Aceptar una conexión entrante
            kind.setText("Conectado como Servidor");
        } catch (IOException e) {
            System.out.println("Hubo un error al aceptar la conexión en el serverSocket: " + e);
        }

        // Inicializa la variable de instancia chatPeer
        chatPeer = new ChatPeer(socket, msj_area, "cliente");
        chatPeer.setDisconnectListener(this); // "this" se refiere a la instancia de Chat que implementa el listener
        chatPeer.start(); // Iniciar el hilo de ChatPeer
        // Configura la lógica para trabajar con el socket (enviar y recibir mensajes, etc.)
    }

    public Chat(int port, String ip, String user) {
        initComponents();

        // Configurar la conexión saliente como cliente
        try {
            socket = new Socket(ip, port); // Conéctate al servidor en localhost
            kind.setText("Conectado como Cliente");
        } catch (IOException e) {
            System.out.println("Hubo un error al crear el socket: " + e);
        }

        // Inicializa la variable de instancia chatPeer
        chatPeer = new ChatPeer(socket, msj_area, "server");
        chatPeer.setDisconnectListener(this); // "this" se refiere a la instancia de Chat que implementa el listener
        chatPeer.start(); // Iniciar el hilo de ChatPeer
        // Configura la lógica para trabajar con el socket (enviar y recibir mensajes, etc.)
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        supbar = new javax.swing.JPanel();
        infbar = new javax.swing.JPanel();
        enviar_msj = new javax.swing.JButton();
        msj_field = new javax.swing.JTextField();
        chat_area = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        msj_area = new javax.swing.JTextArea();
        users_area = new javax.swing.JPanel();
        exportConv = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        importConv = new javax.swing.JButton();
        kind = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SocketChat");
        setLocationByPlatform(true);
        setPreferredSize(new java.awt.Dimension(735, 400));
        setResizable(false);

        supbar.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout supbarLayout = new javax.swing.GroupLayout(supbar);
        supbar.setLayout(supbarLayout);
        supbarLayout.setHorizontalGroup(
            supbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        supbarLayout.setVerticalGroup(
            supbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        infbar.setBackground(new java.awt.Color(255, 255, 255));

        enviar_msj.setBackground(new java.awt.Color(0, 134, 190));
        enviar_msj.setText("Enviar");
        enviar_msj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                enviar_msjMouseReleased(evt);
            }
        });

        msj_field.setToolTipText("Escribe un Mebsaje");

        javax.swing.GroupLayout infbarLayout = new javax.swing.GroupLayout(infbar);
        infbar.setLayout(infbarLayout);
        infbarLayout.setHorizontalGroup(
            infbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infbarLayout.createSequentialGroup()
                .addComponent(msj_field, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enviar_msj, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        infbarLayout.setVerticalGroup(
            infbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(enviar_msj, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(msj_field, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        chat_area.setBackground(new java.awt.Color(255, 255, 255));

        msj_area.setEditable(false);
        msj_area.setColumns(20);
        msj_area.setRows(5);
        jScrollPane1.setViewportView(msj_area);

        javax.swing.GroupLayout chat_areaLayout = new javax.swing.GroupLayout(chat_area);
        chat_area.setLayout(chat_areaLayout);
        chat_areaLayout.setHorizontalGroup(
            chat_areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chat_areaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addContainerGap())
        );
        chat_areaLayout.setVerticalGroup(
            chat_areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chat_areaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addContainerGap())
        );

        users_area.setBackground(new java.awt.Color(255, 255, 255));
        users_area.setPreferredSize(new java.awt.Dimension(120, 0));
        users_area.setRequestFocusEnabled(false);

        javax.swing.GroupLayout users_areaLayout = new javax.swing.GroupLayout(users_area);
        users_area.setLayout(users_areaLayout);
        users_areaLayout.setHorizontalGroup(
            users_areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        users_areaLayout.setVerticalGroup(
            users_areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        exportConv.setBackground(new java.awt.Color(201, 241, 253));
        exportConv.setText("Guardar Conversación");
        exportConv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportConvMouseClicked(evt);
            }
        });

        logout.setBackground(new java.awt.Color(251, 210, 224));
        logout.setText("Cerrar Sesión");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });

        importConv.setBackground(new java.awt.Color(223, 237, 214));
        importConv.setText("Cargar Conversación");
        importConv.setPreferredSize(new java.awt.Dimension(200, 37));
        importConv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                importConvMouseClicked(evt);
            }
        });

        kind.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(logout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportConv, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(importConv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kind, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(supbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(infbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(chat_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(users_area, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(supbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(exportConv, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(importConv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(kind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chat_area, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(users_area, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviar_msjMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enviar_msjMouseReleased
        String mensaje = msj_field.getText();
        if (!mensaje.isEmpty()) {
            // Llama al método sendMessage() del ChatPeer para enviar el mensaje
            chatPeer.sendMessage(mensaje);
            msj_area.append("Tú: " + mensaje + "\n");
            msj_field.setText("");
        }
    }//GEN-LAST:event_enviar_msjMouseReleased

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        System.exit(0);
    }//GEN-LAST:event_logoutMouseClicked

    private void exportConvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportConvMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showSaveDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            try {
                // Obtén la ruta seleccionada
                String rutaArchivo = fileChooser.getSelectedFile().getAbsolutePath();

                // Abre un archivo de texto para escribir
                BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo));

                // Obtiene el texto de la conversación desde el msj_area (JTextArea)
                String conversacion = msj_area.getText();

                // Escribe la conversación en el archivo
                writer.write(conversacion);

                // Cierra el archivo
                writer.close();

                JOptionPane.showMessageDialog(this, "Conversación exportada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al exportar la conversación.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_exportConvMouseClicked

    private void importConvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importConvMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            try {
                // Obtén la ruta seleccionada por el usuario
                String rutaArchivo = fileChooser.getSelectedFile().getAbsolutePath();

                // Abre el archivo de texto para leer
                BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
                StringBuilder conversacion = new StringBuilder();
                String linea;

                // Lee el contenido del archivo línea por línea
                while ((linea = reader.readLine()) != null) {
                    conversacion.append(linea).append("\n");
                }

                // Cierra el archivo
                reader.close();

                // Muestra la conversación en el JTextArea
                msj_area.setText(conversacion.toString());

                JOptionPane.showMessageDialog(this, "Conversación cargada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al cargar la conversación.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_importConvMouseClicked

    public void terCon() {
        // Detener el hilo de ChatPeer
        if (chatPeer != null) {
            chatPeer.stopCom();
        }

        // Cerrar la conexión del socket (si lo estás utilizando)
        if (socket != null && !socket.isClosed()) {
            try {
                JOptionPane.showMessageDialog(this, "Conexión terminada", "Error", JOptionPane.INFORMATION_MESSAGE);
                socket.close();
            } catch (IOException e) {
                System.out.println("Hubo un error al crear el socket: " + e);
                e.printStackTrace();
            }
        }

        //Login log = new Login();
        //log.setVisible(true);
        System.exit(0);
        //this.dispose();
    }

    @Override
    public void onDisconnect() {
        // El otro usuario se desconectó, muestra una alerta
        JOptionPane.showMessageDialog(this, "El otro usuario se ha desconectado.", "Desconexión", JOptionPane.INFORMATION_MESSAGE);
        terCon();
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Chat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chat_area;
    private javax.swing.JButton enviar_msj;
    private javax.swing.JButton exportConv;
    private javax.swing.JButton importConv;
    private javax.swing.JPanel infbar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kind;
    private javax.swing.JButton logout;
    private javax.swing.JTextArea msj_area;
    private javax.swing.JTextField msj_field;
    private javax.swing.JPanel supbar;
    private javax.swing.JPanel users_area;
    // End of variables declaration//GEN-END:variables
}
