package com.zhuhao.threaddemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 线程：
 * 1.
 * 1.线程状态总的可分为五大状态：分别是生、死、可运行、运行、等待/阻塞
 * 2.
 * 一、单线程和多线程
 * 1.单任务和多任务
 * 单任务：在同一时间内，只能完成一件事，后续的任务只能排队执行
 * 多任务：在同一时间内，可以完成多项任务，比如一边敲代码，一边玩炉石。
 * 2.并发和并行
 * 并发：多个任务争抢资源，交替执行，单个cpu即可
 * 并行：多个任务同时进行，互不干扰，多个cpu或者多核cpu执行
 * 3.进程和线程
 * 进程：一个程序至少有一个进程，
 * 线程：进程一般包含一个或多个线程
 * 4.多线程
 * 多线程不是为了提高程序的执行效率，而是为了提高资源的利用率，压榨cpu
 * 以空间换时间
 * 5.调度策略
 * 分时调度策略：cpu为每个线程分配相同的时间片，依次执行。
 * 抢占式调度策略：多个线程抢占资源，谁抢到资源谁执行。
 * <p>
 * java使用的是抢占式调度策略
 * 二、自定义多线程
 * 1.继承Thread类
 * 2.实现Runnable接口 （推荐）
 * 3.实现Callable接口
 * 4.通过线程池获取
 *
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 */
public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
//        test01();
        test03();
    }

//    使用不限制线程数量的线程池
    public static void test03() throws InterruptedException {
        ExecutorService pool2 = Executors.newCachedThreadPool();

        for (int i = 0; i < 6; i++) {
            Thread.sleep(3000);
            pool2.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        System.out.println(Thread.currentThread().getName() + "\t" + j);

                    }
                }
            });

        }
    }

//    使用指定线程数量的线程池
    public static void test02() {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 6; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        System.out.println(Thread.currentThread().getName() + "\t" + j);
                    }
                }
            });
        }

    }

    public static void test01() {
        Demo02Thread d = new Demo02Thread();
        d.start();


        Demo01Runnable d2 = new Demo01Runnable();
        Thread thread = new Thread(d2);
        thread.start();


        Demo03Callable d3 = new Demo03Callable();
        FutureTask<String> futureTask = new FutureTask<>(d3);
        Thread thread1 = new Thread(futureTask);
        thread1.start();
    }

    @Test
    public void test05() throws InterruptedException {
        System.out.println("start");
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("thread end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("33333333");
        Thread.sleep(1000);
        System.out.println("end");
    }

    @Test
    public void test06(){
        ArrayList<Object> list = new ArrayList<>();

        HashMap<Object, Object> map = new HashMap<>();

        for (Object o : list) {
            System.out.println(o);
        }

        System.out.println(map.get("1111"));


    }
}
