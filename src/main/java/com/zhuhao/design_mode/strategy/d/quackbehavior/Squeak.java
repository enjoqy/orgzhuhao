package com.zhuhao.design_mode.strategy.d.quackbehavior;

/**
 * si kui ke
 * @Author halk
 * @Date 2020/11/12 15:45
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("吱吱叫。。");
    }
}
