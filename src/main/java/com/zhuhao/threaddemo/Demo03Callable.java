package com.zhuhao.threaddemo;

import java.sql.SQLOutput;
import java.util.concurrent.Callable;

/**
 * Callable
 * 1.call方法有返回值，run方法没有
 * 2.call方法可以抛出异常，run方法不行
 *
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 */
public class Demo03Callable implements Callable<String> {
    @Override
    public String call() throws Exception {

        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }

        return "程序执行结束";


    }
}
