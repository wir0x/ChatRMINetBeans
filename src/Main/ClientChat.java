package Main;

import Main.clazz.Client;

import Main.clazz.Message;
import Main.interfaces.ChatController;
import Main.interfaces.ChatInterface;
import enumerator.TypeMessageEnum;
import interfaces.ClientInterface;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientChat extends javax.swing.JFrame implements ClientInterface, ChatController {

    private Logger LOG = Logger.getLogger(ClientChat.class.getName());

    private ChatInterface chat;
    private ClientInterface client;
    private List<String> nomeClientes = new ArrayList<String>();
    private static final int MAX_USERS = 10;
    public String selectedUser = null;
    PrivateChat cp = new PrivateChat();

    @Override
    public void updateMessages(Message msg) throws RemoteException {
        LOG.info("updateMessages" + msg);

        if (msg.getTypeMessageEnum() == TypeMessageEnum.PRIVATE) {

            if (client.getNome().equals(msg.getSender()) || client.getNome().equals(msg.getReceiver())) {

                txtAreaMensagens.append(msg.getTextMessage() + "\n");
                cp.updateMessage(msg.getTextMessage());

            }
        } else {
            txtAreaMensagens.append(msg.getTextMessage() + "\n");
        }
    }

    @Override
    public void updateClients(List<String> clients) throws RemoteException {
        LOG.info("updateClients" + clients);

        selectedUser = (String) userList.getSelectedValue();
        this.userList.setListData(clients.toArray());
        this.userList.setSelectedValue(selectedUser, true);
    }


    /**
     * Creates new form TelaPrincipal
     */
    public ClientChat() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaMensagens = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        userList = new javax.swing.JList();
        lblMessage = new javax.swing.JLabel();
        txtMensagem = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnConectar = new javax.swing.JButton();
        lblServer = new javax.swing.JLabel();
        lblPort = new javax.swing.JLabel();
        txtServidor = new javax.swing.JTextField();
        txtPorta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnDesconectar = new javax.swing.JButton();
        btnDesconectar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtAreaMensagens.setColumns(20);
        txtAreaMensagens.setRows(5);
        jScrollPane1.setViewportView(txtAreaMensagens);

        userList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {"aguardando login"};

            public int getSize() {
                return strings.length;
            }

            public Object getElementAt(int i) {
                return strings[i];
            }
        });
        userList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        userList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listUsuariosValueChanged(evt);
            }
        });
        userList.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                listUsersFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                listUsersFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(userList);

        lblMessage.setText("clazz.Message:");

        txtMensagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMessageActionPerformed(evt);
            }
        });

        btnEnviar.setText("enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        lblNome.setText("Nombre:");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        btnConectar.setText("Conectar");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logHandler(evt);
            }
        });

        lblServer.setText("Servidor:");

        lblPort.setText("Puerto:");

        txtServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServerActionPerformed(evt);
            }
        });

        jLabel1.setText("Mensagens");

        jLabel2.setText("Usuarios");

        btnDesconectar.setText("Desconectar");
        btnDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisconnectActionPerformed(evt);
            }
        });

        btnDesconectar1.setLabel("Privado");
        btnDesconectar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisconnect1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(lblMessage)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(txtMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(lblServer)
                                                                        .addComponent(lblNome)
                                                                        .addComponent(lblPort))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(txtNome)
                                                                        .addComponent(txtServidor)
                                                                        .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane2)
                                                        .addComponent(btnConectar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                                        .addComponent(btnDesconectar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnDesconectar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2)
                                                .addGap(43, 43, 43)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblNome)
                                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblServer)
                                                        .addComponent(txtServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnDesconectar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblPort)
                                                        .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 36, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnDesconectar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblMessage)
                                        .addComponent(txtMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logHandler
        String nameClient = txtNome.getText();
        String server = txtServidor.getText().equals("") ? "localhost" : txtServidor.getText();
        int port = txtPorta.getText().equals("") ? 1099 : Integer.parseInt(txtPorta.getText());

        try {

            String url = "rmi//" + server + ":" + port + "/" + "clazz.Chat";
            LOG.info("url " + url);

            chat = (ChatInterface) LocateRegistry.getRegistry(server, port).lookup("clazz.Chat");
            LOG.info("chat " + chat);

            for (ClientInterface cli : chat.getClients()) {
                if (cli.getNome().equals(nameClient)) {
                    LOG.info("This client exists, please select other name");
                    JOptionPane.showMessageDialog(null, "This client exists, please select other name");
                    return;
                }
            }
            if (!(this.chat.getClients().size() >= MAX_USERS)) {
                createNewClient(nameClient);

            } else {
                LOG.info("Number max of users" + MAX_USERS);
                JOptionPane.showMessageDialog(null, "Number max of users" + MAX_USERS);
                return;
            }

        } catch (Exception e) {
            LOG.warning("ERROR LogHandler " + e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_logHandler

    private void createNewClient(String nameClient) {
        try {
            client = new Client(nameClient);
            client.setChatGUI(this);

            this.chat.registrarObserver(client);
            this.chat.registerClient(client.getNome());

            LOG.info("List of names users " + chat.getListNamesClients());

            btnConectar.setEnabled(false);
            txtNome.setEnabled(false);
            txtServidor.setEnabled(false);
            txtPorta.setEnabled(false);

        } catch (Exception re) {
            LOG.warning("ERROR register client" + re.getMessage());
        }
    }

    private void disconnect() {
        try {
            if (this.chat != null)
                this.chat.removeClient(client.getNome());
            this.chat.removerObserver(client);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {

        int indexUser = userList.getSelectedIndex();
        try {
            if (this.userList.isSelectionEmpty()) {
                this.chat.sendMessage(client.getNome(), null, txtMensagem.getText(), TypeMessageEnum.PUBLIC);
            } else {
                String receiver = (String) this.userList.getSelectedValue();
                this.chat.sendMessage(client.getNome(), receiver, txtMensagem.getText(), TypeMessageEnum.PRIVATE);
                userList.setSelectedIndex(indexUser);
            }

        } catch (RemoteException ex) {

            LOG.info("error in btnSend " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "don't send message");
        }
        txtMensagem.setText("");
    }

    private void listUsersFocusGained(FocusEvent evt) {//GEN-FIRST:event_listUsuariosFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_listUsuariosFocusGained

    private void listUsersFocusLost(FocusEvent evt) {//GEN-FIRST:event_listUsuariosFocusLost
        // TODO add your handling code here:
        // Retira todas as seleções da lista de usuários
        //this.userList.clearSelection();
    }//GEN-LAST:event_listUsuariosFocusLost

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        this.userList.clearSelection();
    }//GEN-LAST:event_formMouseClicked

    private void btnDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesconectarActionPerformed
        this.disconnect();
    }//GEN-LAST:event_btnDesconectarActionPerformed

    private void listUsuariosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listUsuariosValueChanged
        // TODO add your handling code here:
        //System.out.println(this.userList.getSelectedIndex());
    }//GEN-LAST:event_listUsuariosValueChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.disconnect();
    }//GEN-LAST:event_formWindowClosing

    private void txtMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMensagemActionPerformed
        btnSendActionPerformed(evt);
    }//GEN-LAST:event_txtMensagemActionPerformed

    private void txtServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServidorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServidorActionPerformed

    private void btnDisconnect1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesconectar1ActionPerformed
        // TODO add your handling code here:


        try {
            cp.setClient(this.client);
            cp.setChat(this.chat);
            cp.lblSender.setText(getNome());
            cp.lblMessage = this.lblMessage;
            cp.lblDest.setText((String) userList.getSelectedValue());
            cp.show();
        } catch (RemoteException ex) {
            Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDesconectar1ActionPerformed

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
            Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientChat().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnDesconectar;
    private javax.swing.JButton btnDesconectar1;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPort;
    private javax.swing.JLabel lblServer;
    public javax.swing.JList userList;
    public javax.swing.JTextArea txtAreaMensagens;
    private javax.swing.JTextField txtMensagem;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPorta;
    private javax.swing.JTextField txtServidor;
    // End of variables declaration//GEN-END:variables


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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setChatGUI(ChatController chat) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
