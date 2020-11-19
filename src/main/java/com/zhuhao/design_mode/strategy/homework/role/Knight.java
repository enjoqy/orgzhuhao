package com.zhuhao.design_mode.strategy.homework.role;

import com.zhuhao.design_mode.strategy.homework.weapon.BowAndArrow;

/**
 * @Author halk
 * @Date 2020/11/12 16:28
 */
public class Knight  extends Role{

    public Knight() {
        this.weapon = new BowAndArrow();
    }

    @Override
    public void name() {
        System.out.println("i am knight..");
    }
}
