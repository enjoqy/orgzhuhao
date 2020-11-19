package com.zhuhao.design_mode.decorator.d;

import org.junit.Test;

/**
 * @Author halk
 * @Date 2020/11/6 14:05
 */
public class AppTest {

    /**
     * 优点：
     * 1.类没有爆炸，没有出现各种各样的类
     * 2.星巴克老板又加入了一种新的饮料茶，不会带来什么影响，符合开闭原则
     *
     * 缺点：
     * 1.类还是很多，但是现在已经是最优的解决方案
     */
    @Test
    public void test01(){

        Beverage decaf = new Decaf();
        Milk milk = new Milk(decaf);
        Milk milk2 = new Milk(milk);
        Mocha mocha = new Mocha(milk2);

        System.out.println(mocha.getDescription() + " : " + mocha.cost());


    }
}
