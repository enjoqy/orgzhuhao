package com.zhuhao.design_mode.strategy.homework;

import com.zhuhao.design_mode.strategy.homework.role.King;
import com.zhuhao.design_mode.strategy.homework.role.Knight;
import com.zhuhao.design_mode.strategy.homework.role.Role;
import com.zhuhao.design_mode.strategy.homework.weapon.BowAndArrow;
import com.zhuhao.design_mode.strategy.homework.weapon.Knife;
import org.junit.Test;

/**
 * 练习：
 * 制作角色类：Role，有几个子类：Knight,King,Queen,Princess
 * 角色的攻击方式，有不同的方式：剑，斧，弓箭，拳头。攻击方式可以在运行时替换
 * @Author halk
 * @Date 2020/11/12 16:23
 */
public class AppTest {

    @Test
    public void test01(){
        Role king = new King();
        king.name();
        king.attack();

        //运行期间改变武器以及攻击方式
        king.setWeapon(new BowAndArrow());
        king.attack();

        System.out.println("-----------");

        Role knight = new Knight();
        knight.name();
        knight.attack();

        knight.setWeapon(new Knife());
        knight.attack();

    }
}
