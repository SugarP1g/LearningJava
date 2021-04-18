package com.SugarP1g.rmi.demo1;

import java.rmi.registry.*;

public class Client {
    public static void main(String[] args) throws Exception {

        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 8888);
        registry.lookup("user");
    }
}
