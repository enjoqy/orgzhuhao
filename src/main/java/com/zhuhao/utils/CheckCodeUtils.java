package com.zhuhao.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author halk
 * @Date 2020/4/9 20:52
 */
public class CheckCodeUtils {


    /**
     * @return void
     * @Author halk
     * @Description 生成四位验证码
     * @Date 2020/4/9 14:46
     * @Param []
     **/
    @Test
    public void test14() {
        //四位验证码
        System.out.println(String.valueOf((new Random().nextInt(8999) + 1000)));

        //六位验证码
        System.out.println(String.valueOf((new Random().nextInt(899999) + 100000)));
    }

    @Test
    public void test15() {

        for (int i = 0; i < 100; i++) {
            //四位验证码
            System.out.println(String.valueOf((new Random().nextInt(10))));
        }
    }

    @Test
    public void generateCode() {
        int len = Math.min(6, 8);

        int min = Double.valueOf(Math.pow(10, len - 1)).intValue();
        System.out.println(min);
        int num = new Random().nextInt(Double.valueOf(Math.pow(10, len + 1)).intValue() - 1);
        System.out.println(num);
        System.out.println(String.valueOf(num + min).substring(0, len));
    }

    @Test
    public void MathPowTest() {

        String str = "18355182591";

        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        String s2="^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$";// 验证手机号
        if(StringUtils.isNotBlank(str)){
            p = Pattern.compile(s2);
            m = p.matcher(str);
            b = m.matches();
        }
        System.out.println(b);
    }

}


