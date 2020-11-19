package com.zhuhao.design_mode.strategy.homework.weapon;

/**
 * 弓和箭
 *
 * @Author halk
 * @Date 2020/11/12 16:37
 */
public class BowAndArrow implements Weapon {
    @Override
    public void attack() {
        System.out.println("使用弓箭，射。。");
    }
}
