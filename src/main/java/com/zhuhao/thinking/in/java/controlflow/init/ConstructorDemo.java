package com.zhuhao.thinking.in.java.controlflow.init;

/**
 * @Author zhuhao
 * @Date 2021/6/19 22:43
 * @desc
 */
public class ConstructorDemo {

    public ConstructorDemo() {
    }

    public ConstructorDemo(double a) {
        System.out.println(a);
    }

    public static void main(String[] args) {
        ConstructorDemo constructorDemo = new ConstructorDemo('a');
        constructorDemo.a = 1;
    }

    private int a;
}


class A {
    public static void main(String[] args) {
        ConstructorDemo constructorDemo = new ConstructorDemo('a');
//        constructorDemo.a = 1;
    }
}
