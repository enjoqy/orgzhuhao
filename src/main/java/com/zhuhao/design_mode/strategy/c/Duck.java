package com.zhuhao.design_mode.strategy.c;

/**
 * @Author halk
 * @Date 2020/11/11 16:49
 */
public abstract class Duck {

    public void swim(){
        System.out.println("游泳");
    }

    /**
     * 鸭子的其他行为和外观
     */
    public abstract void display();
}
