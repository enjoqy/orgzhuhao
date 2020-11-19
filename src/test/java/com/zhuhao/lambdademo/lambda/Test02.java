package com.zhuhao.lambdademo.lambda;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * @Author halk
 * @Date 2020/7/3 0003 15:05
 */
public class Test02 {


    @Test
    public void test02() throws IOException {
        Reader fileReader = new FileReader("F:\\1.txt");
        BufferedReader br = new BufferedReader(fileReader);

        String str;

        StringBuffer sb = new StringBuffer();
        while ((str = br.readLine()) != null) {
            sb.append(str);
            sb.append(" ");
        }

        String[] strArr = sb.toString().split("[^A-Za-z]+");

        System.out.println(strArr.length);

        for (String s : strArr) {
            System.out.println(s + "!!");
        }

    }

    @Test
    public void test01() {

        //第几页
        int page = 1;
        //每页多少条
        int rows = 10;

        //总条数
        int total = 20;

        //总计多少页
        int totalPage = (int) java.lang.Math.ceil(total / rows);

    }

    @Test
    public void test03() {
        for (char i = 0; i < 128; i++) {
            System.out.println((int) i + " : " + i);
            System.out.println(Character.isLowerCase(i));

            List<Integer> list = Arrays.asList(1);
            for (int a : list) {

            }
        }
    }

}
