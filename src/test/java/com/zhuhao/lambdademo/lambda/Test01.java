package com.zhuhao.lambdademo.lambda;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * @Author halk
 * @Date 2020/1/9 13:27
 */
public class Test01 {


    @Test
    public void test01() {
        String str = "D:/java/apache-tomcat-8.5.49/webapps/ddpt/";

        String[] ddpts = str.split("ddpt");

        for (int i = 0; i < ddpts.length; i++) {
            System.out.println(ddpts[i]);
        }
    }

    @Test
    public void test02() {
        float b = 99.0f;
        BigDecimal bigDecimal = new BigDecimal(b);
        System.out.println(bigDecimal);
    }

    @Test
    public void test03() {
        int a = 3;
        int b = 4;

        float c = (float) a / b;

        BigDecimal bd = new BigDecimal(c);
        float v = bd.setScale(2, RoundingMode.HALF_UP).floatValue();


        System.out.println(v);
    }

    /**
     * @return void
     * @Author halk
     * @Description 判断奇偶数
     * @Date 2020/3/17 20:48
     * @Param []
     **/
    @Test
    public void test04() {
        System.out.println("1111");
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine()) {
            String str2 = scanner.nextLine();
            System.out.println("输入的数据为：" + str2);

            int num = scanner.nextInt();
            if ((num & 1) == 0) {
                System.out.println("奇数");
            } else {
                System.out.println("偶数");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("1111");
        while (true){
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            if ((num & 1) == 1) {
                System.out.println("奇数");
            } else {
                System.out.println("偶数");
            }
        }
    }
}
