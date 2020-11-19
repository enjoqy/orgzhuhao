package com.zhuhao.design_mode.strategy.c;

/**
 * @Author halk
 * @Date 2020/11/11 16:51
 */
public class RedHeadDuck extends Duck implements FlyAble, QuackAble  {
    @Override
    public void display() {
        System.out.println("外观是红头鸭");
    }

    @Override
    public void fly() {
        System.out.println("飞、、、、");
    }

    @Override
    public void quack() {
        System.out.println("红头鸭叫、、、");
    }
}
