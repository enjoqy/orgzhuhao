package com.zhuhao.thinking.in.java.controlflow.WhileDemo;

/**
 * @Author zhuhao
 * @Date 2021/6/17 22:15
 * @desc
 */
public class WhileTest {

    static int count = 0;

    static boolean condition(){
        boolean result = Math.random() < 0.99;
        System.out.print(result + ",");
        count++;
        System.out.println(count);
        return result;
    }

    public static void main(String[] args) {
        while (condition()) {
            System.out.println("inside while");
        }
        System.out.println("Exited while  " + count);
    }
}
