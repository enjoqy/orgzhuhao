package com.zhuhao.threaddemo.threaddemo01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {

    public static void main(String[] args) {

    /*    new Thread(new Runnable() {
            @Override
            public void run() {
                Station s = new Station();
                s.run1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Station s1 = new Station();
                s1.run1();
            }
        }).start();*/

        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    Station s = new Station();
                    s.run1();
                }
            });
        }

    }


}
