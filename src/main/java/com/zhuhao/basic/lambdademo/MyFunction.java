package com.zhuhao.basic.lambdademo;

/**
 * 函数式接口，加注解@FunctionalInterface显示的声明为函数式接口，只能有一个抽象方法
 * @author junhi
 * @date 2019/11/6 22:34
 */
@FunctionalInterface
public interface MyFunction {

    void sayHello();

    default  void sayHello2(){}

    default  void sayHello3(){}
}
