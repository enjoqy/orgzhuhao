package com.zhuhao.annotationdemo;

import java.util.Scanner;

/**
 * 注解：
 * 1.“元”
 * 数据至于元数据：
 * 代码之于 元代码
 * 注解之于 元注解
 * 2.jdk1.5+新特性
 * 3.jdk自带的注解
 * 1.Override
 * 4.注解的分类
 * 1.源码的注解，注解只存在于源码中，在class文件中不存在
 * 2.编译时注解，存在于源码中和class文件中
 * 3.运行时注解，存在于源码中和class文件中，并且在程序的运行阶段影响运行逻辑，例如spring框架的auto。。
 * 5.自定义注解
 * 1.关键字:@interface
 * 2.使用元注解描述自定义注解
 * 3.
 *
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 */
public class DemoAnnotation {

    private String name;

    @Deprecated  //过时的
    public void test01() {
        System.out.println();
    }

    @Test01()
    public void test03() {

    }

    @SuppressWarnings("unused")  //压制警告
    public void test02() {
        Scanner scanner = new Scanner(System.in);
    }

    @Override
    public String toString() {
        return "DemoAnnotation{}";
    }

    public static void main(String[] args) {

    }

}
