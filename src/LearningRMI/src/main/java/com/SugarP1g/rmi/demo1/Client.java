package com.SugarP1g.rmi.demo1;

import java.rmi.registry.*;

public class Client {
    public static void main(String[] args) throws Exception {

        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 8888);
        User user = (User) registry.lookup("user");
        System.out.print(user.getName());
    }
}
