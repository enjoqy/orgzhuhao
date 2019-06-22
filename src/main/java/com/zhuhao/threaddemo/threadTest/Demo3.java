package com.zhuhao.threaddemo.threadTest;

/**
 * @author junhi
 * @date 2019/6/22 13:51
 */
public class Demo3 implements Runnable {

    static int count = 0;

    @Override
    public void run() {
        int num = new Demo03().num;
        while (true){
            synchronized (this){
                if(num > 0){
                    count += 100;
                    System.out.println(Thread.currentThread().getName() + "\t" + count);
                    num--;
                }

            }
        }
    }

    public static void main(String[] args) {
        Demo3 demo04 = new Demo3();
        Thread thread = new Thread(demo04, "顾客一");
        Thread thread2 = new Thread(demo04, "顾客二");
        thread.start();
        thread2.start();

    }
}
