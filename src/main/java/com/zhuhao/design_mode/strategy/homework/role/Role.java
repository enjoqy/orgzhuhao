package com.zhuhao.design_mode.strategy.homework.role;

import com.zhuhao.design_mode.strategy.homework.weapon.Weapon;

/**
 * @Author halk
 * @Date 2020/11/12 16:27
 */
public abstract class Role {

    protected Weapon weapon;

    /**
     * 攻击以及攻击的方式（攻击方式由子类决定）
     */
    public void attack(){
        this.weapon.attack();
    }

    /**
     * 角色的名字
     */
    public abstract void name();

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
