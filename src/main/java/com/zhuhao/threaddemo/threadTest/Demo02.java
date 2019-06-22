package com.zhuhao.threaddemo.threadTest;

/**
 * 3.某一家银行可接受顾客的汇款，每进行一次汇款，便可计算出当前汇款总额，现有两名顾客，每人都分3次，
 * 每次100元将钱汇入，编写一个程序，利用多线程来模拟顾客的操作
 *
 * @author junhi
 * @date 2019/6/22 11:35
 */
public class Demo02 implements Runnable {

    static int count = 0;
    static int a = 6;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (a > 0) {
                    a--;
                    count += 100;
                    System.out.println(Thread.currentThread().getName() + "当前汇款总金额为： " + count);
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Demo02 demo02 = new Demo02();
        Thread thread1 = new Thread(demo02, "顾客一");
        Thread thread2 = new Thread(demo02, "顾客二");
        thread1.start();
        thread2.start();

    }


}
