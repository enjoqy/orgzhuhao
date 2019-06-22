package com.zhuhao.threaddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo002 {

    public static void main(String[] args) {

       /* new Thread(new Runnable() {
            @Override
            public void run() {
                Demo001.test001();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Demo03.test009();
            }
        }).start();*/


        ExecutorService pool = Executors.newCachedThreadPool();
        pool.submit(new Runnable() {
            @Override
            public void run() {
                Demo003.test009();

            }
        });

        pool.submit(new Runnable() {
            @Override
            public void run() {
                Demo001.test001();
                System.out.println(Thread.currentThread().getName() + " \t");

            }
        });


    }

    public static void test01() {
        System.out.println("11111111");
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }

    public static void test02() {
        System.out.println("22222222222222222");
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }

}
