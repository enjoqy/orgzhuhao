package com.zhuhao.design_mode.strategy.d.duck;

import com.zhuhao.design_mode.strategy.d.flybehavior.FlyBehavior;
import com.zhuhao.design_mode.strategy.d.quackbehavior.QuackBehavior;

/**
 * @Author halk
 * @Date 2020/11/11 16:49
 */
public abstract class Duck {

    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    /**
     * 执行飞的方法，具体执行哪种，由子类来决定
     */
    public void performFly(){
        flyBehavior.fly();
    }

    /**
     * 执行的叫方法，具体执行哪种，由子类来决定
     */
    public void performQuack(){
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("游泳");
    }

    /**
     * 鸭子的其他行为和外观
     */
    public abstract void display();

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
