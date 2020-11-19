package com.zhuhao.design_mode.strategy.homework.role;

import com.zhuhao.design_mode.strategy.homework.weapon.Sword;

/**
 * 王后
 *
 * @Author halk
 * @Date 2020/11/12 16:29
 */
public class Queen extends Role {

    public Queen() {
        this.weapon = new Sword();
    }

    @Override
    public void name() {
        System.out.println("i am queen...");
    }
}
