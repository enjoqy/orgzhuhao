package com.zhuhao.design_mode.strategy.homework.role;

import com.zhuhao.design_mode.strategy.homework.weapon.Knife;

/**
 * @Author halk
 * @Date 2020/11/12 16:30
 */
public class Princess extends Role {

    public Princess() {
        this.weapon = new Knife();
    }

    @Override
    public void name() {
        System.out.println("i am princess...");
    }
}
