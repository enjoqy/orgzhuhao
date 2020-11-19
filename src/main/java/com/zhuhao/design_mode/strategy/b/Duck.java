package com.zhuhao.design_mode.strategy.b;

/**
 * @Author halk
 * @Date 2020/11/11 16:49
 */
public abstract class Duck {

    public void quack(){
        System.out.println("呱呱叫");
    }

    public void swim(){
        System.out.println("游泳");
    }

    public void fly(){
        System.out.println("飞起来。。。。");
    }

    /**
     * 鸭子的其他行为和外观
     */
    public abstract void display();
}
