package com.zhuhao.design_mode.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author halk
 * @Date 2020/11/17 17:14
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }


    /**
     * public static Object newProxyInstance(ClassLoader loader,
     * Class<?>[] interfaces,
     * InvocationHandler h) {
     * <p>
     * ClassLoader loader: 指定目标对象使用的类加载器，获取加载器的方法固定(xx.getClass().getClassLoader())
     * Class<?>[] interfaces: 目标对象实现的接口类型，使用泛型方法确认类型
     * InvocationHandler h： 事情处理执行目标对象的方法时，会触发事情处理器方法，会把当前执行的目标对象方法作为参数传入
     *
     * @return
     */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("jdk代理开始。。。。");
                        Object returnVal = method.invoke(target, args);
                        System.out.println("jdk代理结束。。。");
                        return returnVal;
                    }
                });
    }
}
