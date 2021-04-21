package com.SugarP1g.rmi.hellormi;

import java.rmi.registry.*;

public class HelloRMIServer2 {
    public static void main(String[] argv) throws Exception {
        String addr = argv[0];
        int port = Integer.parseInt(argv[1]);
        String name = argv[2];
        /*
         * 指定动态IP，而不是默认的"127.0.0.1"。这句必须在createRegistry()
         * 之前，而不是rebind()之前。
         */
        System.setProperty("java.rmi.server.hostname", addr);
        Registry r = LocateRegistry.createRegistry(port);
        HelloRMIInterface hello = new HelloRMIInterfaceImpl();
        r.rebind(name, hello);
    }
}