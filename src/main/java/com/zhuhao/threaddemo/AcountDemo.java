package com.zhuhao.threaddemo;

public class AcountDemo {

    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        Thread t1 = new Thread(sharedData);
        Thread t2 = new Thread(sharedData);
        t1.setName("小明");
        t2.setName("xiaohong");
        t1.start();
        t2.start();
    }
}
