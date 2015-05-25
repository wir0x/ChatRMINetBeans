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
public interface ChatController extends Remote {
    public void updateMessages(Message msg) throws RemoteException;

    public void updateClients(List<String> clientes) throws RemoteException;
}
