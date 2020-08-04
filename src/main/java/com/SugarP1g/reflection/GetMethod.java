package com.SugarP1g.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetMethod {

    public static void getMethod() throws NoSuchMethodException {
        System.out.println("[+] getMethod:");
        Class stdClass = Student1.class;
        // 获取public方法getScore，参数为String:
        System.out.println(stdClass.getMethod("getScore", String.class));
        // 获取继承的public方法getName，无参数:
        System.out.println(stdClass.getMethod("getName"));
        System.out.println();
        System.out.println("[+] getDeclaredMethod:");
        // 获取private方法getGrade，参数为int:
        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));
        System.out.println();
    }

    public static void invokeMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String s = "Hello World";

        System.out.println("[+] invoke.");
        Class stdClass = String.class;
        Method func = stdClass.getMethod("substring", int.class);
        System.out.println(func.invoke(s, 6));
        System.out.println();
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        getMethod();
        invokeMethod();
    }
}

class Student1 extends Person1 {
    public int getScore(String type) {
        return 99;
    }

    private int getGrade(int year) {
        return 1;
    }
}

class Person1 {
    public String getName() {
        return "Person";
    }
}
