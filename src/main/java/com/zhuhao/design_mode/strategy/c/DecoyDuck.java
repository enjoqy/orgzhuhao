package com.zhuhao.design_mode.strategy.c;

/**
 * 不能飞也不能叫
 *
 * @Author halk
 * @Date 2020/11/12 11:32
 */
public class DecoyDuck extends Duck {
    @Override
    public void display() {
        System.out.println("外观是诱饵鸭。。。");
    }
}
