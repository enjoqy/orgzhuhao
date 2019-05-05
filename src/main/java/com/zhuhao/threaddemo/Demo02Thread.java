package com.zhuhao.threaddemo;

public class Demo02Thread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }

    }
}
