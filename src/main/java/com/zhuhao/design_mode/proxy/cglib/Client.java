package com.zhuhao.design_mode.proxy.cglib;

/**
 * @Author halk
 * @Date 2020/11/19 16:13
 */
public class Client {

    public static void main(String[] args) {
        TeacherDao teacherDao = new TeacherDao();
        ProxyFactory proxyFactory = new ProxyFactory(teacherDao);
        TeacherDao proxyInstance = (TeacherDao)proxyFactory.getProxyInstance();
        proxyInstance.teach();
    }
}
