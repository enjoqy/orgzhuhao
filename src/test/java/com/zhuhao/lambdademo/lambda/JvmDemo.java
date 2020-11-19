package com.zhuhao.lambdademo.lambda;

import java.util.ArrayList;

/**
 * @Author halk
 * @Date 2020/7/2 0002 16:07
 */
public class JvmDemo {

    byte[] a = new byte[1024*100];

    public static void main(String[] args) throws InterruptedException {
        ArrayList<JvmDemo> list = new ArrayList<>();
        for (;;){
            list.add(new JvmDemo());
            Thread.sleep(10);
        }
    }

}
