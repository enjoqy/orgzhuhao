package com.zhuhao.design_mode.principle.segregation.improve;

/**
 * 接口隔离职责
 * - 把接口进行拆分
 *
 * @Author halk
 * @Date 2020/10/29 15:13
 */
public class Segregation1 {
    public static void main(String[] args) {
        A a = new A();
        a.depend1(new B());
        a.depend2(new B());
        a.depend3(new B());

        C c = new C();
        c.depend1(new D());
        c.depend4(new D());
        c.depend5(new D());

        Demo demo = new Demo();
        demo.demo1();
        demo.demo2();
        demo.demo3();


    }
}

interface Interface1 {
    void operation1();
}

interface Interface2 {

    void operation2();

    void operation3();

}

interface Interface3 {
    void operation4();

    void operation5();
}

/**
 * B类，但是指挥使用到1、2、3方法
 */
class B implements Interface1, Interface2 {
    @Override
    public void operation1() {
        System.out.println("B 实现了 operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B 实现了 operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B 实现了 operation3");
    }

}

/**
 * D类，但是指挥使用到1、4、5方法
 */
class D implements Interface1, Interface3 {
    @Override
    public void operation1() {
        System.out.println("D 实现了 operation1");
    }

    @Override
    public void operation4() {
        System.out.println("D 实现了 operation4");
    }

    @Override
    public void operation5() {
        System.out.println("D 实现了 operation5");
    }
}

/**
 * A类通过接口Interface1依赖（使用）B类，但是指挥使用到1、2、3方法
 */
class A {
    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend2(Interface2 i) {
        i.operation2();
    }

    public void depend3(Interface2 i) {
        i.operation3();
    }

}

/**
 * C类通过接口Interface1依赖（使用）D类，但是指挥使用到1、4、5方法
 */
class C {
    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend4(Interface3 i) {
        i.operation4();
    }

    public void depend5(Interface3 i) {
        i.operation5();
    }

}

/**
 * jdk1.8之后接口可以有默认实现，接口的默认实现可以通过实例来调用，一定程度上解决了接口隔离
 */
interface InterfaceDemo{
    default void demo1(){
        System.out.println("interface1....");
    }

    void demo2();

    void demo3();
}

class Demo implements InterfaceDemo{

    @Override
    public void demo2() {
        System.out.println("2222222");
    }

    @Override
    public void demo3() {
        System.out.println("333333");
    }
}
