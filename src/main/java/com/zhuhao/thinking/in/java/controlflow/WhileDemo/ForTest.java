package com.zhuhao.thinking.in.java.controlflow.WhileDemo;

/**
 * @Author zhuhao
 * @Date 2021/6/17 22:29
 * @desc
 */
public class ForTest {

    public static void main(String[] args) {
        int i = 1;
        outer:
        for (; ; ) {
            System.out.println("----------------");
            inner:
            for (; 1 < 10; i++) {
                System.out.println("i = " + i);
                if (i == 2) {
                    System.out.println("continue");
                    continue;
                }
                if (i == 3){
                    System.out.println("break");
                    i++;
                    break ;
                }
                lll:
                if (i == 7){
                    System.out.println("continue outer");
                    i++;
                    continue outer;
                }
                if (i == 8){
                    System.out.println("break outer");
                    break outer;
                }
                for (int k = 0; k < 5; k++) {
                    if (k == 3){
                        System.out.println("continue inner");
                        continue inner;
                    }
                }

            }
        }
    }
}
