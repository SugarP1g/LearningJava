package com.SugarP1g.reflection;

import java.lang.reflect.Method;
import java.util.Base64;

public class HelloDefineClass {
    public static void main(String[] args) throws Exception {
        Method defineClass =
                ClassLoader.class.getDeclaredMethod("defineClass", String.class,
                        byte[].class, int.class, int.class);
        defineClass.setAccessible(true);
        byte[] code =
                Base64.getDecoder().decode("yv66vgAAADQAGwoABgANCQAOAA8IABAKABEAEgcAEwcAFAEABjxpbml0" +
                        "PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAApTb3VyY2VGaWxlAQAKSGVsbG8uamF2YQwA" +
                        "BwAIBwAVDAAWABcBAAtIZWxsbyBXb3JsZAcAGAwAGQAaAQAFSGVsbG8BABBqYXZhL2xhbmcvT2JqZWN0" +
                        "AQAQamF2YS9sYW5nL1N5c3RlbQEAA291dAEAFUxqYXZhL2lvL1ByaW50U3RyZWFtOwEAE2phdmEvaW8v" +
                        "UHJpbnRTdHJlYW0BAAdwcmludGxuAQAVKExqYXZhL2xhbmcvU3RyaW5nOylWACEABQAGAAAAAAABAAEA" +
                        "BwAIAAEACQAAAC0AAgABAAAADSq3AAGyAAISA7YABLEAAAABAAoAAAAOAAMAAAACAAQABAAMAAUAAQALAAAAAgAM");
                        Class hello = (Class) defineClass.invoke(
                                ClassLoader.getSystemClassLoader(),
                                "Hello", code, 0, code.length
                        );
        hello.newInstance();
    }
}
