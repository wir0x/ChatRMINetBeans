package Main.clazz;

import Main.interfaces.ChatController;
import Main.interfaces.ChatInterface;
import interfaces.ClientInterface;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Client extends UnicastRemoteObject implements ClientInterface, Serializable {
    private String nome;
    private List<Message> messages;
    private ChatController chatGUI;

    public void setChatGUI(ChatController chatGUI) {
        this.chatGUI = chatGUI;
    }

    public List<Message> getMessages() throws RemoteException {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Client(String nome) throws RemoteException {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }


    public void update(ChatInterface chat) throws RemoteException {

        chatGUI.updateClients(chat.getListNamesClients());
        chatGUI.updateMessages(chat.getMessages().get(chat.getMessages().size() - 1));
        System.out.println(this.chatGUI);
    }


}
