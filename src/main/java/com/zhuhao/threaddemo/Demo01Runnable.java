package com.zhuhao.threaddemo;

public class Demo01Runnable implements Runnable {
    @Override
    public void run() {

        for (int i = 0; i < 122; i++) {
            System.out.println(i);
        }
    }
}
