package com.zhuhao.lambdademo.lambda;

import org.halk.lombok.User;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author halk
 * @Date 2020/1/9 13:27
 */
public class Test01 {

    @Test
    public void test05() {
        Float a = null;
        Float b = 1f;
        System.out.println(a != null);
    }


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

    @Test
    public void test06(){

        ArrayList<Object> list = new ArrayList<>();

        list.add(1);
        list.add(2);

        System.out.println(list.subList(1,2));
    }

    @Test
    public void test07(){

        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("4", 4);
        map.put("3", 3);

        map.put("6", new User());
        map.put("7", "7");
        map.put("5", 5);

        Enumeration<String> keys = map.keys();
        while (keys.hasMoreElements()){
            String key = keys.nextElement();
            System.out.println(map.get(key));
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
