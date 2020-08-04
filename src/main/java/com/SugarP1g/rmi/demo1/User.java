package com.SugarP1g.rmi.demo1;

import java.rmi.RemoteException;
import java.rmi.Remote;

public interface User extends Remote {
    public String getName() throws RemoteException;

    public User getUser() throws RemoteException;

    public void updateName(String name) throws RemoteException;

}
