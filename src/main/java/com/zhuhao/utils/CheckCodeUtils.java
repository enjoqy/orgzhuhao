package com.zhuhao.utils;

import org.junit.Test;

import java.util.Random;

/**
 * @Author halk
 * @Date 2020/4/9 20:52
 */
public class CheckCodeUtils {


    /**
     * @Author halk
     * @Description 生成四位验证码
     * @Date 2020/4/9 14:46
     * @Param []
     * @return void
     **/
    @Test
    public void test14(){
        //四位验证码
        System.out.println( String.valueOf((new Random().nextInt(8999) + 1000)));

        //六位验证码
        System.out.println(String.valueOf((new Random().nextInt(899999) + 100000)));
    }
}


