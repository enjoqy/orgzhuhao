package com.zhuhao.design_mode.strategy.d.flybehavior;

/**
 * @Author halk
 * @Date 2020/11/12 15:40
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("用翅膀飞。。。。");
    }
}
