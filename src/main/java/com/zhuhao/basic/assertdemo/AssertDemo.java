package com.zhuhao.basic.assertdemo;

/**
 * 断言：也就是所谓的assertion，是jdk1.4后加入的新功能。
 * 它主要使用在代码开发和测试时期，用于对某些关键数据的判断，如果这个关键数据不是你程序所预期的数据，程序就提出警告或退出。
 * 当软件正式发布后，可以取消断言部分的代码。
 *
 * idea默认关闭断言功能，需要在VM options中添加‘-ea’参数开启，‘-da’参数关闭或者不写
 *
 * @Author halk
 * @Date 2020/11/24 10:43
 **/
public class AssertDemo {
    static int i = 5;

    public static void main(String[] args) {
        //这个成员变量的值可以变，但最终必须还是回到原值5
        assert i == 6;
        System.out.println("如果断言正常，我就被打印");
    }
}
