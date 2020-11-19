package com.zhuhao.design_mode.strategy.d.quackbehavior;

/**
 * @Author halk
 * @Date 2020/11/12 15:43
 */
public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("鸭子叫。。");
    }
}
