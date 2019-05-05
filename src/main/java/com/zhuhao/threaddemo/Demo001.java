package com.zhuhao.threaddemo;

public class Demo001 {

    public static void test001() {
        System.out.println("11111111");
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " \t" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}
