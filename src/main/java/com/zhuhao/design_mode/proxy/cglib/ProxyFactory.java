package com.zhuhao.design_mode.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author halk
 * @Date 2020/11/19 15:40
 */
public class ProxyFactory implements MethodInterceptor {

    /**
     * 维护一个目标对象
     */
    private Object target;

    /**
     * 构造器，传入一个被代理对象
     *
     * @param target
     */
    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 返回一个代理对象，是target对象的代理对象
     *
     * @return
     */
    public Object getProxyInstance() {

        //创建一个工具类
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //创建子类对象，即代理对象
        return enhancer.create();
    }

    /**
     * @return java.lang.Object
     * @Author halk
     * @Description 重写intercept方法，会调用目标对象的方法
     * @Date 2020/11/19 16:12
     * @Param [o, method, args, methodProxy]
     **/
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        System.out.println("Cglib代理模式开始、、、、");
        Object returnVal = method.invoke(target, args);
        System.out.println("Cglib代理模式结束、、、、");
        return returnVal;
    }
}
