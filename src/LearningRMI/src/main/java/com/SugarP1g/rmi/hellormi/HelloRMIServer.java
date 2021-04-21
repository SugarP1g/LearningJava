package com.SugarP1g.rmi.hellormi;

import java.rmi.registry.*;

public class HelloRMIServer {
    public static void main(String[] argv) throws Exception {
        int port = 1099;
        String name = "HelloRMIInterface";
        /*
         * https://docs.oracle.com/javase/8/docs/api/java/rmi/registry/LocateRegistry.html
         *
         * port默认使用1099/TCP，addr默认使用"0.0.0.0"
         *
         * server 启动时会监听两个端口，一个是指定的端口，一个是随机端口
         */
        Registry r = LocateRegistry.createRegistry(port);
        HelloRMIInterface hello = new HelloRMIInterfaceImpl();
        /*
         * https://docs.oracle.com/javase/8/docs/api/java/rmi/registry/Registry.html
         *
         * 第一形参内容任意，起唯一标识作用
         */
        r.rebind(name, hello);
    }
}