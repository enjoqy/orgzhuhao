package com.zhuhao.design_mode.strategy.d.duck;

import com.zhuhao.design_mode.strategy.d.flybehavior.FlyNoWay;
import com.zhuhao.design_mode.strategy.d.quackbehavior.MuteQuack;

/**
 * 不能飞也不能叫
 *
 * @Author halk
 * @Date 2020/11/12 11:32
 */
public class DecoyDuck extends Duck {

    /**
     * 这里决定父类Duck中的飞和叫调用哪个方法
     */
    public DecoyDuck() {
        this.flyBehavior = new FlyNoWay();
        this.quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("外观是诱饵鸭。。。");
    }
}
