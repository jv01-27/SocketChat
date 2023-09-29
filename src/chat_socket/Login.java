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

import java.awt.Color;
import javax.swing.JOptionPane;
import java.io.*;
import java.net.*;
import javax.swing.ToolTipManager;

public class Login extends javax.swing.JFrame {

    TextFieldEvent correction = new TextFieldEvent();
    int xMouse, yMouse;

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        favicon = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        userTxt = new javax.swing.JTextField();
        passLabel = new javax.swing.JLabel();
        passTxt = new javax.swing.JPasswordField();
        portLabel = new javax.swing.JLabel();
        loginBtn = new javax.swing.JPanel();
        loginBtnTxt = new javax.swing.JLabel();
        portTxt = new javax.swing.JTextField();
        servidorCheckBox = new javax.swing.JCheckBox();
        ipTxt = new javax.swing.JTextField();
        ipLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login - SocketChat");
        setLocationByPlatform(true);
        setName("login_frame"); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        favicon.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        favicon.setText("SocketChat");

        title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title.setText("INICIAR SESIÓN");

        userLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        userLabel.setText("USUARIO (ManténElCursorAquí)");
        userLabel.setToolTipText("server | cliente | admin");
        userLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userLabelMouseClicked(evt);
            }
        });

        userTxt.setBackground(new java.awt.Color(250, 250, 250));
        userTxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        userTxt.setForeground(new java.awt.Color(204, 204, 204));
        userTxt.setText("Ingrese su nombre de usuario");
        userTxt.setBorder(null);
        userTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userTxtMousePressed(evt);
            }
        });
        userTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userTxtKeyTyped(evt);
            }
        });

        passLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        passLabel.setText(" CONTRASEÑA (ManténElCursorAquí)");
        passLabel.setToolTipText("server | cliente | admin");
        passLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passLabelMouseClicked(evt);
            }
        });

        passTxt.setBackground(new java.awt.Color(250, 250, 250));
        passTxt.setForeground(new java.awt.Color(204, 204, 204));
        passTxt.setText("********");
        passTxt.setBorder(null);
        passTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passTxtMousePressed(evt);
            }
        });
        passTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passTxtKeyTyped(evt);
            }
        });

        portLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        portLabel.setText("Puerto (Ej. 2580)");

        loginBtn.setBackground(new java.awt.Color(0, 134, 190));

        loginBtnTxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        loginBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        loginBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginBtnTxt.setText("INGRESAR");
        loginBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout loginBtnLayout = new javax.swing.GroupLayout(loginBtn);
        loginBtn.setLayout(loginBtnLayout);
        loginBtnLayout.setHorizontalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginBtnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginBtnLayout.setVerticalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginBtnLayout.createSequentialGroup()
                .addComponent(loginBtnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        portTxt.setBackground(new java.awt.Color(250, 250, 250));
        portTxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        portTxt.setForeground(new java.awt.Color(204, 204, 204));
        portTxt.setText("Ingrese el número de puerto");
        portTxt.setBorder(null);
        portTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                portTxtMousePressed(evt);
            }
        });
        portTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                portTxtKeyTyped(evt);
            }
        });

        servidorCheckBox.setSelected(true);
        servidorCheckBox.setText("Soy Servidor");
        servidorCheckBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                servidorCheckBoxMouseClicked(evt);
            }
        });

        ipTxt.setBackground(new java.awt.Color(250, 250, 250));
        ipTxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        ipTxt.setBorder(null);
        ipTxt.setEnabled(false);
        ipTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ipTxtMousePressed(evt);
            }
        });
        ipTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ipTxtKeyTyped(evt);
            }
        });

        ipLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ipLabel.setText("IP Del servidor");
        ipLabel.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(servidorCheckBox)
                    .addComponent(title)
                    .addComponent(favicon)
                    .addComponent(ipLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ipTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(favicon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(portLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(portTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(servidorCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ipLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ipTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/login.bg.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseExited
        loginBtn.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_loginBtnTxtMouseExited

    private void loginBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseEntered
        loginBtn.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_loginBtnTxtMouseEntered

    private void loginBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseClicked
        // validacion de contraseña, wacha el nombre de los botones y objetos
        //String Cliente = "";//"empleado";//"hackerman";
        String[] usuarios = {"server", "cliente", "admin"};
        String[] contrasenas = {"server", "cliente", "admin"};

        String usuarioIngresado = userTxt.getText();
        String contrasenaIngresada = new String(passTxt.getPassword());

        boolean credencialesCorrectas = false;

        // Verificar las credenciales ingresadas con los datos almacenados
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i].equals(usuarioIngresado) && contrasenas[i].equals(contrasenaIngresada)) {
                credencialesCorrectas = true;
                break;
            }
        }

        if (credencialesCorrectas) {

            /*
            En este código, el bloque try intenta crear un ServerSocket en el puerto deseado.
            Si el puerto no es un número válido, se capturará una NumberFormatException.
            Si el puerto está en uso, se capturará una IOException.
            Dependiendo de la excepción capturada, se mostrará un mensaje de error adecuado al usuario.
             */
            try {
                String port = portTxt.getText();
                String ipAdd = ipTxt.getText();
                boolean serServidor = servidorCheckBox.isSelected();

                int desiredPort = Integer.parseInt(port);
                if (serServidor) {
                    System.out.println("Iniciando como servidor en el puerto " + desiredPort);

                    ServerSocket serverSocket = new ServerSocket(desiredPort);
                    System.out.println("ServerSocket creado");

                    JOptionPane.showMessageDialog(this, "Esperando la conexión de un cliente", "Servidor", JOptionPane.INFORMATION_MESSAGE);

                    Chat chatS = new Chat(serverSocket, usuarioIngresado);
                    chatS.setVisible(true);
                    System.out.println("Ventana de Chat abierta como servidor");
                    this.dispose();
                } else {
                    System.out.println("Iniciando como cliente en el puerto " + desiredPort);

                    Chat chat = new Chat(desiredPort, ipAdd, usuarioIngresado);
                    chat.setVisible(true);
                    System.out.println("Ventana de Chat abierta como cliente");
                    this.dispose();
                }

            } catch (NumberFormatException e) {
                System.err.println("Error al convertir el puerto: " + e.getMessage());
                JOptionPane.showMessageDialog(
                        this, "El puerto debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                System.err.println("Error de E/S: " + e.getMessage());
                JOptionPane.showMessageDialog(this, "El puerto está en uso.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Usuario/Contraseña Erróneos");
        }
    }//GEN-LAST:event_loginBtnTxtMouseClicked

    private void passTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passTxtKeyTyped
        correction.text_numberKeyPress(evt, passTxt);
    }//GEN-LAST:event_passTxtKeyTyped

    private void passTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passTxtMousePressed

        if (String.valueOf(passTxt.getPassword()).equals("********")) {
            passTxt.setText("");
            passTxt.setForeground(Color.black);
        }
        if (userTxt.getText().isEmpty()) {
            userTxt.setText("Ingrese su nombre de usuario");
            userTxt.setForeground(Color.gray);
        }
        if (portTxt.getText().isEmpty()) {
            portTxt.setText("Ingrese el número de puerto");
            portTxt.setForeground(Color.gray);
        }


    }//GEN-LAST:event_passTxtMousePressed

    private void userTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userTxtKeyTyped
        correction.text_numberKeyPress(evt, userTxt);
    }//GEN-LAST:event_userTxtKeyTyped

    private void userTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxtMousePressed

        if (userTxt.getText().equals("Ingrese su nombre de usuario")) {
            userTxt.setText("");
            userTxt.setForeground(Color.black);
        }
        if (String.valueOf(passTxt.getPassword()).isEmpty()) {
            passTxt.setText("********");
            passTxt.setForeground(Color.gray);
        }
        if (portTxt.getText().isEmpty()) {
            portTxt.setText("Ingrese el número de puerto");
            portTxt.setForeground(Color.gray);
        }

    }//GEN-LAST:event_userTxtMousePressed

    private void portTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_portTxtMousePressed
        if (portTxt.getText().equals("Ingrese el número de puerto")) {
            portTxt.setText("");
            portTxt.setForeground(Color.black);
        }
        if (String.valueOf(passTxt.getPassword()).isEmpty()) {
            passTxt.setText("********");
            passTxt.setForeground(Color.gray);
        }
        if (userTxt.getText().isEmpty()) {
            userTxt.setText("Ingrese su nombre de usuario");
            userTxt.setForeground(Color.gray);
        }
    }//GEN-LAST:event_portTxtMousePressed

    private void portTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_portTxtKeyTyped
        correction.text_numberKeyPress(evt, userTxt);
    }//GEN-LAST:event_portTxtKeyTyped

    private void servidorCheckBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_servidorCheckBoxMouseClicked
        boolean serServidor = servidorCheckBox.isSelected();
        if (serServidor) {
            ipLabel.setEnabled(false);
            ipTxt.setEnabled(false);
        } else {
            ipLabel.setEnabled(true);
            ipTxt.setEnabled(true);
        }
    }//GEN-LAST:event_servidorCheckBoxMouseClicked

    private void ipTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ipTxtMousePressed

    }//GEN-LAST:event_ipTxtMousePressed

    private void ipTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ipTxtKeyTyped
        correction.numberDecilmalKeyPress(evt, userTxt);
    }//GEN-LAST:event_ipTxtKeyTyped

    private void userLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLabelMouseClicked
        // Mostrar el tooltip al hacer clic
        userLabel.setToolTipText("server | cliente | admin");
        // Tiempo en milisegundos antes de ocultar el tooltip (en este caso, 2 segundos)
        ToolTipManager.sharedInstance().setDismissDelay(5000); 
    }//GEN-LAST:event_userLabelMouseClicked

    private void passLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passLabelMouseClicked
        // Mostrar el tooltip al hacer clic
        passLabel.setToolTipText("server | cliente | admin");
        // Tiempo en milisegundos antes de ocultar el tooltip (en este caso, 2 segundos)
        ToolTipManager.sharedInstance().setDismissDelay(5000); 
    }//GEN-LAST:event_passLabelMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel favicon;
    private javax.swing.JLabel ipLabel;
    private javax.swing.JTextField ipTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel loginBtn;
    private javax.swing.JLabel loginBtnTxt;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passTxt;
    private javax.swing.JLabel portLabel;
    private javax.swing.JTextField portTxt;
    private javax.swing.JCheckBox servidorCheckBox;
    private javax.swing.JLabel title;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables
}
