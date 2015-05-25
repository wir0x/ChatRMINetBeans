package Main;

import Main.clazz.Message;
import Main.interfaces.ChatController;
import Main.interfaces.ChatInterface;
import enumerator.TypeMessageEnum;
import interfaces.ClientInterface;

import javax.swing.*;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PrivateChat extends javax.swing.JFrame implements ClientInterface, ChatController {

    private Logger LOG = Logger.getLogger(PrivateChat.class.getName());

    private ChatInterface chat;
    private ClientInterface client;


    public ChatInterface getChat() {
        return chat;
    }

    public void setChat(ChatInterface chat) {
        this.chat = chat;
    }

    public ClientInterface getClient() {
        return client;
    }

    public void setClient(ClientInterface client) {
        this.client = client;
    }

    public PrivateChat() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDest = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaMessagePrivate = new javax.swing.JTextArea();
        txtMessage = new javax.swing.JTextField();
        lblMessage = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        btnEnviar1 = new javax.swing.JButton();
        lblSender = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblDest.setText("Destinatario");
        lblDest.setName("lbDest"); // NOI18N

        txtAreaMessagePrivate.setColumns(20);
        txtAreaMessagePrivate.setRows(5);
        jScrollPane1.setViewportView(txtAreaMessagePrivate);

        txtMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMessageActionPerformed(evt);
            }
        });

        lblMessage.setText("clazz.Message:");

        btnEnviar.setText("enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMessageActionPerformed(evt);
            }
        });

        btnEnviar1.setText("enviar");
        btnEnviar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });

        lblSender.setText("Remitente");
        lblSender.setName("lblRemit"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jScrollPane1)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblMessage)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)))
                                                .addGap(34, 34, 34))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(btnEnviar1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                                                .addGap(43, 43, 43))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(lblSender)
                                                .addGap(63, 63, 63)
                                                .addComponent(lblDest)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblSender)
                                        .addComponent(lblDest))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblMessage)
                                        .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEnviar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
        );

        lblDest.getAccessibleContext().setAccessibleName("lblDest");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMessageActionPerformed(java.awt.event.ActionEvent evt) {
        btnSendMessageActionPerformed(evt);
    }

    private void btnSendMessageActionPerformed(java.awt.event.ActionEvent evt) {
        try {

            this.chat.sendMessage(lblSender.getText(), lblDest.getText(), txtMessage.getText(), TypeMessageEnum.PRIVATE);

        } catch (RemoteException ex) {
            LOG.info("btnSendMessage" + ex.getMessage());
            JOptionPane.showMessageDialog(null, "class.Message don't send");
        }
        txtMessage.setText("");
    }


    @Override
    public void updateMessages(Message msg) throws RemoteException {
        if (msg.getTypeMessageEnum() == TypeMessageEnum.PRIVATE) {

            if (client.getNome().equals(msg.getSender()) || client.getNome().equals(msg.getReceiver())) {
                txtAreaMessagePrivate.append(msg.getTextMessage() + "\n");
            }
        } else {
            txtAreaMessagePrivate.append(msg.getTextMessage() + "\n");
        }
    }


    public void updateMessage(String message) {

        txtAreaMessagePrivate.append(message + "\n");

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
            Logger.getLogger(PrivateChat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(PrivateChat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PrivateChat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PrivateChat.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrivateChat().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnEnviar1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblDest;
    public javax.swing.JLabel lblMessage;
    public javax.swing.JLabel lblSender;
    private javax.swing.JTextArea txtAreaMessagePrivate;
    private javax.swing.JTextField txtMessage;

    @Override
    public String getNome() throws RemoteException {
        return client.getNome();
    }

    @Override
    public void setNome(String nome) throws RemoteException {
        client.setNome(nome);
    }

    @Override
    public List<Message> getMessages() throws RemoteException {
        return chat.getMessages();
    }

    @Override
    public void update(ChatInterface chat) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateClients(List<String> clients) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setChatGUI(ChatController chat) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
