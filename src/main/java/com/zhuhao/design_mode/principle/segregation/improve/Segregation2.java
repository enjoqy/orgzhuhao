package com.zhuhao.design_mode.principle.segregation.improve;

/**
 * 接口隔离职责
 * - 把接口进行拆分
 * - 利用jdk1.8的特性（接口或者抽象方法可有默认实现、用default或static修饰）完成接口隔离
 *
 * @Author halk
 * @Date 2020/10/29 15:13
 */
public class Segregation2 {
    public static void main(String[] args) {
        AA a = new AA();
        a.depend1(new BB());
        a.depend2(new BB());
        a.depend3(new BB());

        CC c = new CC();
        c.depend1(new DD());
        c.depend4(new DD());
        c.depend5(new DD());

    }
}

/**
 * 接口可以有自己的默认实现
 */
interface Interface11 {
    default void operation1() {
        System.out.println("interface default implementation 1");
    }

    default void operation2() {
        System.out.println("interface default implementation 3");
    }

    default void operation3() {
        System.out.println("interface default implementation 3");
    }

    default void operation4() {
        System.out.println("interface default implementation 4");
    }

    default void operation5() {
        System.out.println("interface default implementation 5");
    }
}


/**
 * B类，但是指挥使用到1、2、3方法
 */
class BB implements Interface11 {
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
class DD implements Interface11 {
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
class AA {
    public void depend1(Interface11 i) {
        i.operation1();
    }

    public void depend2(Interface11 i) {
        i.operation2();
    }

    public void depend3(Interface11 i) {
        i.operation3();
    }

}

/**
 * C类通过接口Interface1依赖（使用）D类，但是指挥使用到1、4、5方法
 */
class CC {
    public void depend1(Interface11 i) {
        i.operation1();
    }

    public void depend4(Interface11 i) {
        i.operation4();
    }

    public void depend5(Interface11 i) {
        i.operation5();
    }

}
