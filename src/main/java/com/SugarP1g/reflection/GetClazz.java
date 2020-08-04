package com.SugarP1g.reflection;

public class GetClazz {

    public static void getclazz() throws ClassNotFoundException {
        // 直接通过一个class的静态变量class获取
        Class cls1 = String.class;

        // 如果我们有一个实例变量，可以通过该实例变量提供的getClass()方法获取
        String s = "Hello";
        Class cls2 = s.getClass();

        // 如果知道一个class的完整类名，可以通过静态方法Class.forName()获取
        Class cls3 = Class.forName("java.lang.String");

        // 因为Class实例在JVM中是唯一的，所以，上述方法获取的Class实例是同一个实例。
        // 可以用==比较两个Class实例:
        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);
        System.out.println(cls2 == cls3);
    }

    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
        System.out.println();
    }

    public static void getClazzInfo() {
        System.out.println("****Class String:****");
        printClassInfo("".getClass());
        System.out.println("****Class Runnable:****");
        printClassInfo(Runnable.class);
        System.out.println("****Class String[]:****");
        printClassInfo(String[].class);
        System.out.println("****Class int:****");
        printClassInfo(int.class);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        getclazz();
        getClazzInfo();
    }
}
