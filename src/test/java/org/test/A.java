package org.test;

/**
 * @Author halk
 * @Date 2020/9/10 16:54
 */
public class A {

    private static A a;
    static String aa = "123";


    public static void main(String[] args) {
        System.out.println(a.aa);
        System.out.println(a);
        System.out.println(new A());
        System.out.println(new A());

    }
}
