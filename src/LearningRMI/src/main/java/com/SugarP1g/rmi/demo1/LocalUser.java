package com.SugarP1g.rmi.demo1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LocalUser extends UnicastRemoteObject implements User {
    public String name;
    public int age;

    public LocalUser(String name, int age) throws RemoteException {
        super();
        this.name = name;
        this.age = age;
    }

    public User getUser() {
        return this;
    }

    public String getName() {
        return "[" + this.name + "]";
    }

    public void updateName(String name) {
        this.name = name;
    }
}
