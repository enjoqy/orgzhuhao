package com.zhuhao.design_mode.strategy.homework.weapon;

/**
 * 剑
 *
 * @Author halk
 * @Date 2020/11/12 16:33
 */
public class Sword implements Weapon {
    @Override
    public void attack() {
        System.out.println("使用剑，刺、、、");
    }
}
