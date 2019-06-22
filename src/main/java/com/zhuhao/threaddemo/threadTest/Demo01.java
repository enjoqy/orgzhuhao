package com.zhuhao.threaddemo.threadTest;

import org.junit.Test;

/**
 * 1.有一个抽奖池,该抽奖池中存放了奖励的金额,该抽奖池用一个数组int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
 * 创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”，随机从arr数组中获取奖项元素并打印在控制台上
 *
 * @author junhi
 * @date 2019/6/22 11:01
 */
public class Demo01 implements Runnable{

    int[] arr = {10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300 };
    int num = arr.length;
    boolean[] flag = new boolean[num];

    @Override
    public void run() {
        while (true){
            synchronized (this){
                if(num > 0){
                    int index = (int) (Math.random()*arr.length);
                    int get = arr[index];

                    //代表这张券被抽过了
                    if(flag[index] != true){
                        flag[index] = true;
                        System.out.println(Thread.currentThread().getName() + "产生了一个大奖： " + get);
                        num--;
                    }

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        Thread thread = new Thread(demo01, "抽奖池1");
        Thread thread2 = new Thread(demo01, "抽奖池2");
        thread.start();
        thread2.start();
    }

    @Test
    public void test(){
        boolean[] b = new boolean[4];
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }

}
