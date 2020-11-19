package com.zhuhao.design_mode.strategy.c;

/**
 * @Author halk
 * @Date 2020/11/12 10:09
 */
public class MallardDuck extends Duck implements FlyAble, QuackAble {
    @Override
    public void display() {
        System.out.println("外观是绿头鸭");
    }

    @Override
    public void fly() {
        System.out.println("飞、、、、");
    }

    @Override
    public void quack() {
        System.out.println("野鸭叫、、、、");
    }
}
