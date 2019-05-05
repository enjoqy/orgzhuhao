package com.zhuhao.threaddemo.threaddemo01;

/**
 * 程序分析：1.票数要使用同一个静态值
 * <p>
 * 2.为保证不会出现卖出同一个票数，要java多线程同步锁。
 * <p>
 * 设计思路：1.创建一个站台类Station，继承Thread，重写run方法，在run方法里面执行售票操作！
 * 售票要使用同步锁：即有一个站台卖这张票时，其他站台要等这张票卖完！
 * <p>
 * 2.创建主方法调用类
 *
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 */
public class Station {

    static int tick = 1000;


    public void run1() {
        while (tick > 0) {
            synchronized ("11") {
                if (tick > 0) {
                    System.out.println(Thread.currentThread().getName() + "票卖了\t" + tick + "\t张");
                    tick--;
                } else {
                    System.out.println("票卖完了");
                }
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
