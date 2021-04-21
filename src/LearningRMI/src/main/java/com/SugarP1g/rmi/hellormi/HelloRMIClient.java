package com.SugarP1g.rmi.hellormi;

import java.rmi.registry.*;

public class HelloRMIClient {
    public static void main(String[] argv) throws Exception {
        String addr = "127.0.0.1";
        int port = 1099;
        String name = "HelloRMIInterface";
        String sth = "this is rmi test.";
        /*
         * https://docs.oracle.com/javase/8/docs/api/java/rmi/registry/LocateRegistry.html
         */
        Registry r = LocateRegistry.getRegistry(addr, port);
        HelloRMIInterface hello = (HelloRMIInterface) r.lookup(name);
        String resp = hello.Echo(sth);
        System.out.println(resp);
    }
}