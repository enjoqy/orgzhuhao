package com.zhuhao.design_mode.strategy.homework.weapon;

/**
 * 刀
 *
 * @Author halk
 * @Date 2020/11/12 16:35
 */
public class Knife implements Weapon {
    @Override
    public void attack() {
        System.out.println("使用刀，砍。。。");
    }
}
