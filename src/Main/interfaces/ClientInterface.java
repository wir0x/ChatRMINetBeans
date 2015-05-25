package Main.interfaces;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Main.clazz.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author Nelson Henrique
 */
public interface ClientInterface extends Remote {
    public String getNome() throws RemoteException;

    public void setNome(String nome) throws RemoteException;

    public void setChatGUI(ChatController chat) throws RemoteException;

    public List<Message> getMessages() throws RemoteException;

    public void update(ChatInterface chat) throws RemoteException;
    //public void setClientesLogados(List<String> nomes) throws RemoteException;
    //public void receberMensagem(String msg) throws RemoteException;
    //public void setChat(Observable chat) throws RemoteException;
}
