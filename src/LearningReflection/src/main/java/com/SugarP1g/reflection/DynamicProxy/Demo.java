package com.SugarP1g.reflection.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Demo {
    public static void main(String[] args) {
        // 定义一个InvocationHandler实例，它负责实现接口的方法调用
        InvocationHandler hander = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        };
        // 通过Proxy.newProxyInstance()创建interface实例，它需要3个参数：
        // - 使用的ClassLoader，通常就是接口类的ClassLoader；
        // - 需要实现的接口数组，至少需要传入一个接口进去；
        // - 用来处理接口方法调用的InvocationHandler实例。
        Hello hello = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(), new Class[]{Hello.class}, hander);
        hello.morning("Bob");
    }
}

/**
 * 动态代理实际上是JVM在运行期动态创建class字节码并加载的过程，它并没有什么黑魔法，把上面的动态代理改写为静态实现类大概长这样：
 * public class HelloDynamicProxy implements Hello {
 *     InvocationHandler handler;
 *     public HelloDynamicProxy(InvocationHandler handler) {
 *         this.handler = handler;
 *     }
 *     public void morning(String name) {
 *         handler.invoke(
 *            this,
 *            Hello.class.getMethod("morning", String.class),
 *            new Object[] { name });
 *     }
 * }
 */
interface Hello {
    void morning(String name);
}
