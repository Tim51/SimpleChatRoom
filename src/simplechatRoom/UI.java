package simplechatRoom;

import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UI extends javax.swing.JFrame implements Runnable {

    private ClientLogic clientLogic;
    private int logSize; 

    public UI() {
        initComponents();
        clientLogic = new ClientLogic();     
        logSize = 0;
        //clientLogic.connectToServer("192.168.1.91", 4444);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        changeNamePopup = new javax.swing.JDialog();
        popupOkButton = new javax.swing.JButton();
        popupNameField = new javax.swing.JTextField();
        popupCancelButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        userListPopup = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        userListTextArea = new javax.swing.JTextArea();
        openingDialog = new javax.swing.JDialog();
        serverIPTextField = new javax.swing.JTextField();
        serverPortTextField = new javax.swing.JTextField();
        serverIPLabel = new javax.swing.JLabel();
        serverPortLabel = new javax.swing.JLabel();
        connectButton = new javax.swing.JButton();
        openingDialogLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        textField = new javax.swing.JTextField();
        jMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        connectMenuItem = new javax.swing.JMenuItem();
        changeNameMenuItem = new javax.swing.JMenuItem();
        openUserListMenuItem = new javax.swing.JMenuItem();
        quitMenuItem = new javax.swing.JMenuItem();

        popupOkButton.setText("OK");
        popupOkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupOkButtonActionPerformed(evt);
            }
        });

        popupNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                popupNameFieldKeyPressed(evt);
            }
        });

        popupCancelButton.setText("Cancel");
        popupCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupCancelButtonActionPerformed(evt);
            }
        });

        nameLabel.setText("Name");
        nameLabel.setToolTipText("Names must only contain letters and digits and also must start with a letter");

        javax.swing.GroupLayout changeNamePopupLayout = new javax.swing.GroupLayout(changeNamePopup.getContentPane());
        changeNamePopup.getContentPane().setLayout(changeNamePopupLayout);
        changeNamePopupLayout.setHorizontalGroup(
            changeNamePopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changeNamePopupLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(changeNamePopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(popupNameField)
                    .addGroup(changeNamePopupLayout.createSequentialGroup()
                        .addComponent(popupCancelButton)
                        .addGap(18, 18, 18)
                        .addComponent(popupOkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        changeNamePopupLayout.setVerticalGroup(
            changeNamePopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeNamePopupLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(changeNamePopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(popupNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(changeNamePopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(popupOkButton)
                    .addComponent(popupCancelButton))
                .addGap(18, 18, 18))
        );

        userListPopup.setTitle("Users Online");

        userListTextArea.setColumns(20);
        userListTextArea.setLineWrap(true);
        userListTextArea.setRows(5);
        userListTextArea.setFocusable(false);
        jScrollPane2.setViewportView(userListTextArea);

        javax.swing.GroupLayout userListPopupLayout = new javax.swing.GroupLayout(userListPopup.getContentPane());
        userListPopup.getContentPane().setLayout(userListPopupLayout);
        userListPopupLayout.setHorizontalGroup(
            userListPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userListPopupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addContainerGap())
        );
        userListPopupLayout.setVerticalGroup(
            userListPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userListPopupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
        );

        openingDialog.setAlwaysOnTop(true);
        openingDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                openingDialogWindowClosing(evt);
            }
        });

        serverIPLabel.setText("Server IP");
        serverIPLabel.setToolTipText("xxx.xxx.xxx.xxx");

        serverPortLabel.setText("Server Port");
        serverPortLabel.setToolTipText("1-5 digit number");

        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout openingDialogLayout = new javax.swing.GroupLayout(openingDialog.getContentPane());
        openingDialog.getContentPane().setLayout(openingDialogLayout);
        openingDialogLayout.setHorizontalGroup(
            openingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(openingDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(openingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(openingDialogLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(openingDialogLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(connectButton)
                        .addGap(26, 26, 26))
                    .addGroup(openingDialogLayout.createSequentialGroup()
                        .addGroup(openingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(serverPortLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(serverIPLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(openingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(serverPortTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(serverIPTextField, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        openingDialogLayout.setVerticalGroup(
            openingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(openingDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(openingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serverIPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serverIPLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(openingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serverPortTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serverPortLabel))
                .addGroup(openingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(openingDialogLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(connectButton)
                        .addContainerGap())
                    .addGroup(openingDialogLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(openingDialogLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simple Chat Room");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        textArea.setLineWrap(true);
        textArea.setRows(5);
        textArea.setText("Connecting...");
        textArea.setWrapStyleWord(true);
        textArea.setFocusable(false);
        jScrollPane1.setViewportView(textArea);

        textField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textFieldKeyPressed(evt);
            }
        });

        fileMenu.setText("File");
        fileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuActionPerformed(evt);
            }
        });

        connectMenuItem.setText("Connect");
        connectMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(connectMenuItem);

        changeNameMenuItem.setText("Change name");
        changeNameMenuItem.setEnabled(false);
        changeNameMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeNameMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(changeNameMenuItem);

        openUserListMenuItem.setText("Open user list");
        openUserListMenuItem.setEnabled(false);
        openUserListMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openUserListMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openUserListMenuItem);

        quitMenuItem.setText("Quit");
        quitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(quitMenuItem);

        jMenuBar.add(fileMenu);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textField, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileMenuActionPerformed
        this.getOwner().dispatchEvent(new WindowEvent(this.getOwner(), WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_fileMenuActionPerformed

    private void quitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitMenuItemActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_quitMenuItemActionPerformed

    private void textFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            clientLogic.sendMessage(textField.getText());
            
            textField.setText("");
        }
    }//GEN-LAST:event_textFieldKeyPressed

    private void changeNameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeNameMenuItemActionPerformed
        changeNamePopup.setResizable(false);
        changeNamePopup.setLocation(this.getX()+30,this.getY()+80);
        
        popupNameField.setText(clientLogic.getName());
        
        changeNamePopup.pack();
        changeNamePopup.setVisible(true);
    }//GEN-LAST:event_changeNameMenuItemActionPerformed

    private void popupCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupCancelButtonActionPerformed
        changeNamePopup.dispatchEvent(new WindowEvent(changeNamePopup,WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_popupCancelButtonActionPerformed

    private void popupOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupOkButtonActionPerformed
        if (!new UsernameVerifier().verify(popupNameField)) {
            return;
        }
        
        clientLogic.setName(popupNameField.getText());
        
        changeNamePopup.dispatchEvent(new WindowEvent(changeNamePopup,WindowEvent.WINDOW_CLOSING));
        
    }//GEN-LAST:event_popupOkButtonActionPerformed

    private void popupNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_popupNameFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            popupOkButton.doClick();
        }
    }//GEN-LAST:event_popupNameFieldKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (clientLogic.isConnected()) {
            clientLogic.sendLeave();
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        new Thread(this,"updateTextArea").start();
    }//GEN-LAST:event_formWindowOpened

    private void openUserListMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openUserListMenuItemActionPerformed
        userListPopup.setResizable(false);
        userListPopup.setLocation(this.getX()+30,this.getY()+80);
        
        userListPopup.pack();
        userListPopup.setVisible(true);
    }//GEN-LAST:event_openUserListMenuItemActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        openingDialogLabel.setText("");
        
        if (!new IPVerifier().verify(serverIPTextField)) {
            openingDialogLabel.setText("serverIP not valid");
            return;
        }
        if (!new PortVerifier().verify(serverPortTextField)) {
            openingDialogLabel.setText("port not valid");
            return;
        }
        
        clientLogic.connectToServer(serverIPTextField.getText(), Integer.parseInt(serverPortTextField.getText()));

        if (!clientLogic.isConnected()) {
            openingDialogLabel.setText("failed to connect");
            return;
        }

        openUserListMenuItem.setEnabled(true);
        changeNameMenuItem.setEnabled(true);
        connectMenuItem.setEnabled(false);
        
        openingDialog.dispatchEvent(new WindowEvent(openingDialog,WindowEvent.WINDOW_CLOSING)); 
    }//GEN-LAST:event_connectButtonActionPerformed

    private void openingDialogWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_openingDialogWindowClosing
        this.setEnabled(true);
    }//GEN-LAST:event_openingDialogWindowClosing

    private void connectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectMenuItemActionPerformed
        openingDialog.setLocation(this.getX()+30,this.getY()+80);
        openingDialog.setVisible(true);
    }//GEN-LAST:event_connectMenuItemActionPerformed

    @Override
    public void run() {
        //this.setEnabled(false);
        openingDialog.setResizable(false);
        openingDialog.setLocation(this.getX()+30,this.getY()+80);
        
        openingDialog.pack();
        openingDialog.setVisible(true);
        
        textArea.setText("");
        while (true) {
            try {
                Thread.sleep(100);
                
                for (int i=logSize; i<clientLogic.getLog().size();i++) {
                    textArea.append(clientLogic.getLog().get(i)+"\n");
                    
                    logSize++;
                }
                
                if (clientLogic.userListChanged()) {
                    userListTextArea.setText("");
                    for (int i=0; i<clientLogic.getUserList().size();i++) {
                        userListTextArea.append(clientLogic.getUserList().get(i)+"\n");  
                    }
                    clientLogic.setUserListChanged(false);
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
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
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem changeNameMenuItem;
    private javax.swing.JDialog changeNamePopup;
    private javax.swing.JButton connectButton;
    private javax.swing.JMenuItem connectMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JMenuItem openUserListMenuItem;
    private javax.swing.JDialog openingDialog;
    private javax.swing.JLabel openingDialogLabel;
    private javax.swing.JButton popupCancelButton;
    private javax.swing.JTextField popupNameField;
    private javax.swing.JButton popupOkButton;
    private javax.swing.JMenuItem quitMenuItem;
    private javax.swing.JLabel serverIPLabel;
    private javax.swing.JTextField serverIPTextField;
    private javax.swing.JLabel serverPortLabel;
    private javax.swing.JTextField serverPortTextField;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextField textField;
    private javax.swing.JDialog userListPopup;
    private javax.swing.JTextArea userListTextArea;
    // End of variables declaration//GEN-END:variables
}
