package Main.interfaces;

import Main.clazz.Message;
import Main.enumator.TypeMessageEnum;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author Nelson Henrique
 */
public interface ChatInterface extends Remote {
    void sendMessage(String remetente, String destinatario, String texto, TypeMessageEnum tipo) throws RemoteException;

    void registrarObserver(ClientInterface o) throws RemoteException;

    void removeClient(String cli) throws RemoteException;

    void removerObserver(ClientInterface o) throws RemoteException;

    void notifyObserver() throws RemoteException;

    List<Message> getMessages() throws RemoteException;

    List<ClientInterface> getClients() throws RemoteException;

    List<String> getListNamesClients() throws RemoteException;

    String registerClient(String cli) throws RemoteException;
}
