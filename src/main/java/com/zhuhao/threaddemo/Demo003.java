package com.zhuhao.threaddemo;

public class Demo003 {

    public static void test009() {
        System.out.println("22222222222");
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
