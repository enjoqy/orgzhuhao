package com.zhuhao.design_mode.strategy.d.duck;

import com.zhuhao.design_mode.strategy.d.flybehavior.FlyNoWay;
import com.zhuhao.design_mode.strategy.d.quackbehavior.Squeak;

/**
 * 橡皮鸭子，rua bo er
 *
 * @Author halk
 * @Date 2020/11/12 10:44
 */
public class RubberDuck extends Duck{

    /**
     * 决定父类的叫和飞（不能叫不能飞）
     */
    public RubberDuck() {
        this.flyBehavior = new FlyNoWay();
        this.quackBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("外观是橡皮鸭。。。。");
    }
}
