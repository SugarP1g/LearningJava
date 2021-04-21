package com.SugarP1g.rmi.hellormi;

import java.rmi.*;

/*
 * The Interface must always be public and extend Remote.
 *
 * All methods described in the Remote interface must list RemoteException
 * in their throws clause.
 */
public interface HelloRMIInterface extends Remote {
    public String Echo(String sth) throws RemoteException;
}