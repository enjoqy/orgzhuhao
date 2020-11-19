package com.zhuhao.design_mode.strategy.a;

import org.junit.Test;

/**
 * 有一家游戏公司开发了一款游戏，角色都是鸭子，不同的鸭子之间有共性，为了提高代码重用性，将鸭子的共性提升至Duck中
 *
 * @Author halk
 * @Date 2020/11/11 16:48
 */
public class AppTest {

    @Test
    public void test01() {
        Duck redHeadDuck = new RedHeadDuck();
        redHeadDuck.display();
        redHeadDuck.quack();
        redHeadDuck.swim();

        Duck mallardDuck = new MallardDuck();
        mallardDuck.swim();
        mallardDuck.quack();
        mallardDuck.display();
    }
}
