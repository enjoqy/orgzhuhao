package com.zhuhao.lambdademo;

import java.util.Arrays;
import java.util.List;

/**
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 */
public class LambdaDemo01 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("111", "22", "3");

        //TODO
        list.stream().filter(name -> name.length() == 2).forEach(System.out::println);

        list.forEach(System.out::println);


    }
}
