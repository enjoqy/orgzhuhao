package com.zhuhao.design_mode.proxy.dynamic;

/**
 * jdk代理，动态代理
 * @Author halk
 * @Date 2020/11/18 15:14
 */
public class Client {
    public static void main(String[] args) {
        TeacherDao teacherDao = new TeacherDao();
        ProxyFactory proxyFactory = new ProxyFactory(teacherDao);
        ITeacherDao instance = (ITeacherDao)proxyFactory.getProxyInstance();
        instance.teach();
        instance.name();
    }
}
