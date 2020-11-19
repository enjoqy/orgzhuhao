package com.zhuhao.design_mode.proxy.staticproxy;

/**
 * @Author halk
 * @Date 2020/11/17 14:11
 */
public class Client {
    public static void main(String[] args) {
        //创建目标对象（被代理对象）
        TeachDao teachDao = new TeachDao();

        //创建代理对象，同时将被代理对象传递给代理对象
        TeachDaoProxy teachDaoProxy = new TeachDaoProxy(teachDao);

        //通过代理对象，调用到被代理对象的方法
        //即：执行的是代理对象的方法，代理对象再去调用目标对象的方法
        teachDaoProxy.teach();
    }
}
