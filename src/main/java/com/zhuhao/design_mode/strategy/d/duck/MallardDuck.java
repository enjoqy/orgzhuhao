package com.zhuhao.design_mode.strategy.d.duck;

import com.zhuhao.design_mode.strategy.d.flybehavior.FlyWithWings;
import com.zhuhao.design_mode.strategy.d.quackbehavior.Quack;

/**
 * @Author halk
 * @Date 2020/11/12 10:09
 */
public class MallardDuck extends Duck {

    /**
     * 这里决定父类Duck中的飞和叫调用哪个方法
     */
    public MallardDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("外观是绿头鸭");
    }

}
