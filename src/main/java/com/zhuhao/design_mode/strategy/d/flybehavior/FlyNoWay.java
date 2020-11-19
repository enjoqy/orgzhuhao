package com.zhuhao.design_mode.strategy.d.flybehavior;

/**
 * @Author halk
 * @Date 2020/11/12 15:41
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不会飞。。");
    }
}
