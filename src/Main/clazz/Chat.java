package Main.clazz;

import Main.enumator.TypeMessageEnum;
import Main.interfaces.ChatInterface;
import Main.interfaces.ClientInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class Chat extends UnicastRemoteObject implements ChatInterface {
    private static final long serialVersionUID = 1L;
    private List<ClientInterface> clients;
    private List<String> mensagensPublicas;
    private List<Message> messages;
    private List<String> nameClients;
    private List<ClientInterface> observers;

    public List<String> getListNamesClients() {
        return nameClients;
    }

    public Chat() throws RemoteException {
//        UnicastRemoteObject.exportObject(this, 0);
        this.clients = new ArrayList<ClientInterface>();
        this.messages = new ArrayList<Message>();
        this.nameClients = new ArrayList<String>();
        this.observers = new ArrayList<ClientInterface>();
    }

    public String registerClient(String nameClient) throws RemoteException {
        try {
            if (!clients.isEmpty()) {
                for (ClientInterface clientInterface : clients) {
                    if (clientInterface.getNome().equals(nameClient)) {
                        return "this clients exist";
                    }
                }
            }
            ClientInterface client = new Client(nameClient);
            this.clients.add(client);
            this.nameClients.add(nameClient);
            this.notifyObserver();
        } catch (Exception e) {
            System.err.println("ERROR (chat): " + e.getMessage());
            e.printStackTrace();
        }
        return "Success client registered";
    }


    public void sendMessage(String remetente, String destinatario, String texto, TypeMessageEnum tipo) throws RemoteException {
        System.out.println("sendMessage" + remetente + " " + destinatario + " " + texto + " ");

        String msg = "";

        if (!this.clients.isEmpty()) {
            this.messages.add(new Message(remetente, destinatario, texto, tipo));
            this.notifyObserver();
        }
    }

    public List<String> getMensagensPublicas() throws RemoteException {
        return this.mensagensPublicas;
    }

    @Override
    public List<Message> getMessages() throws RemoteException {
        return this.messages;
    }

    public List<ClientInterface> getClients() throws RemoteException {
        return this.clients;
    }


    @Override
    public void registrarObserver(ClientInterface cli) throws RemoteException {
        this.observers.add(cli);
        this.messages.add(new Message(cli.getNome(), null, null, TypeMessageEnum.LOGIN));
    }

    @Override
    public void removerObserver(ClientInterface cli) throws RemoteException {
        this.observers.remove(cli);
    }

    @Override
    public void notifyObserver() throws RemoteException {
        for (ClientInterface observer : this.observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeClient(String cli) throws RemoteException {
        try {
            if (!clients.isEmpty()) {
                boolean clienteEncontrado = false;
                ClientInterface clienteARemover = null;
                for (ClientInterface cliente : clients) {
                    if (cliente.getNome().equals(cli)) {
                        clienteEncontrado = true;
                        clienteARemover = cliente;
                        this.messages.add(new Message(cliente.getNome(), null, null, TypeMessageEnum.LOGOUT));

                    }
                }
                if (clienteEncontrado) {
                    this.clients.remove(clienteARemover);
                    this.nameClients.remove(clienteARemover.getNome());
                    System.out.println("Excluido:" + clienteARemover.hashCode() + "\n");
                    this.notifyObserver();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
