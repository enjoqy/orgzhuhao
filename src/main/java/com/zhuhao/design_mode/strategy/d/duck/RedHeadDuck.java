package com.zhuhao.design_mode.strategy.d.duck;

import com.zhuhao.design_mode.strategy.d.flybehavior.FlyWithWings;
import com.zhuhao.design_mode.strategy.d.quackbehavior.Quack;

/**
 * @Author halk
 * @Date 2020/11/11 16:51
 */
public class RedHeadDuck extends Duck  {

    public RedHeadDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("外观是红头鸭");
    }

}
