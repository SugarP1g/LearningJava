package com.SugarP1g.rmi.hellormi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloRMIInterfaceImpl extends UnicastRemoteObject implements HelloRMIInterface {
    private static final long serialVersionUID = 0x5120131473637a00L;

    protected HelloRMIInterfaceImpl() throws RemoteException {
        super();
    }

    public String Echo(String sth) throws RemoteException {
        /*
         * 故意加一对[]，将来抓包时便于识别请求、响应
         */
        return ("[" + sth + "]");
    }
}