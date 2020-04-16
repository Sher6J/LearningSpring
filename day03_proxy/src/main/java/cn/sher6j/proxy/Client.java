package cn.sher6j.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个消费者
 * @author sher6j
 * @create 2020-04-14-16:07
 */
public class Client {

    public static void main(String[] args) {
        /*
        原来，直接联系厂家
         */
//        Producer producer = new Producer();
//        producer.saleProduct(10000f);

        final Producer producer = new Producer();//匿名内部类访问外部成员时，要求外部成员final

        /**
         * 动态代理：
         *  特点：字节码随用随创建，随用随加载
         *  作用：不修改源码的基础上对方法增强
         *  分类：
         *      基于接口的动态代理
         *      基于子类的动态代理
         *  基于接口的动态代理：
         *      涉及的类：Proxy
         *      提供者：JDK官方
         *  如何创建代理对象：
         *      使用Proxy类中的newProxyInstance方法
         *  创建代理对象的要求：
         *      被代理类最少实现一个接口，如果没有则不能 使用
         *  newProxyInstance方法的参数：
         *      Classloader：类加载器
         *          它是用于加载代理对象字节码的，和被代理对象使用相同的类加载器。
         *          代理谁就写谁的getClass().getClassLoader()。固定写法
         *      Class[]：字节码数组
         *          它是用于让代理对象和被代理对象有相同方法，实现接口相同就可以保证有相同方法
         *          代理谁就写谁的getClass().getInterfaces()。固定写法
         *      InvocationHandler：用于提供用于增强的代码
         *          它是让我们写如何代理。一般都是写一个该接口的实现类，通常情况下都是匿名内部类，但是不必须
         *          此接口的实现类都是谁用谁写
         *
         */
        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 作用：执行被代理对象的任何接口方法都会经过该方法
                     * 方法参数的含义
                     * @param proxy     代理对象的引用
                     * @param method    当前执行的方法
                     * @param args      当前执行方法所需的参数
                     * @return          和被代理对象方法有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //提供增强的代码
                        Object returnValue = null;
                        //1.获取方法执行的参数
                        Float money = (Float) args[0];
                        //2.判断当前方法是不是销售
                        if ("saleProduct".equals(method.getName())) {
                            //使生产者是能拿到钱的0.8，其他的归代理商了
                            returnValue = method.invoke(producer, money*0.8f);
                        }
                        return returnValue;
                    }
                });

        proxyProducer.saleProduct(10000f);
    }
}
