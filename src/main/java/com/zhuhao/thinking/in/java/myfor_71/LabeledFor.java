package com.zhuhao.thinking.in.java.myfor_71;

/**
 * 测试带标签的break、continue
 *
 * @Author halk
 * @Date 2020/11/12 21:01
 */
public class LabeledFor {

    public static void main(String[] args) {
        int i = 0;
        outer: for (; true; ) {
            inner: for (; i < 10; i++) {
                System.out.println("i= " + i);
                if (i == 2) {
                    System.out.println("continue");
                    continue;
                }
                if (i == 3) {
                    System.out.println("print");
                    i++;  //这里需要i++，只有当i不满足i<10的时候，里面的for循环才不会执行（否则就是死循环）
                    break;
                }
                if (i == 7) {
                    System.out.println("continue outer");
                    i++;
                    continue outer;
                }
                if (i == 8) {
                    System.out.println("break outer");
                    break outer;
                }
                for (int k = 0; k < 5; k++) {
                    if (k == 3) {
                        System.out.println("continue inner");
                        continue inner;
                    }
                }
            }
        }
    }
}
