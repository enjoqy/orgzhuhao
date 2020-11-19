package com.zhuhao.design_mode.strategy.homework.role;

import com.zhuhao.design_mode.strategy.homework.weapon.Sword;

/**
 * @Author halk
 * @Date 2020/11/12 16:28
 */
public class King extends Role {

    /**
     * 国王用剑攻击
     */
    public King() {
        this.weapon = new Sword();
    }

    @Override
    public void name() {
        System.out.println("i am king..");
    }


}
