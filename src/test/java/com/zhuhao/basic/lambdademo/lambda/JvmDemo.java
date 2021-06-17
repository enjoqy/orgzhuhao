package com.zhuhao.basic.lambdademo.lambda;

import java.util.ArrayList;

/**
 *
 *
 * @Author halk
 * @Date 2020/7/2 0002 16:07
 */
public class JvmDemo {

    /**
     * 代表着这个类的实例拥有100kb的一个属性，也就是实例至少占用100kb的内存，用来测内存溢出再好不过了
     */
    byte[] a = new byte[1024*100];

    public static void main(String[] args) throws InterruptedException {
        ArrayList<JvmDemo> list = new ArrayList<>();
        for (;;){
            list.add(new JvmDemo());
            Thread.sleep(2);
        }
    }

}
