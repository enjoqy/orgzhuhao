package com.zhuhao.design_mode.strategy.c;

/**
 * 橡皮鸭子，rua bo er
 *
 * @Author halk
 * @Date 2020/11/12 10:44
 */
public class RubberDuck extends Duck implements QuackAble{

    /**
     * 橡皮鸭叫声与真鸭子不一样，所以重写了叫声
     */
    @Override
    public void quack() {
        System.out.println("吱吱叫。。。");
    }

    @Override
    public void display() {
        System.out.println("外观是橡皮鸭。。。。");
    }
}
