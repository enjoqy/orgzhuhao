package org.test;

/**
 * @Author halk
 * @Date 2020/9/10 16:56
 */
public class B extends A {

    public B() {
        super();
        System.out.println("bb");
    }

    @Override
    public void play() {
        System.out.println("B");
    }


}
