package com.zhuhao.design_mode.strategy.b;

import org.junit.Test;

/**
 * 有一家游戏公司开发了一款游戏，角色都是鸭子，不同的鸭子之间有共性，为了提高代码重用性，将鸭子的共性提升至Duck中
 * <p>
 * 游戏公司老总提出新需求：需要让鸭子飞起来
 * <p>
 * 程序员：只需在Duck类中添加一个fly方法，其子类也就具有了fly方法
 *
 * 此时看似解决问题了，实际上Duck的子类全都会飞了，橡皮鸭是玩具不能飞的，而且重写了叫声，所以这种方案不适合
 * 后期加入各种鸭子的时候（木头鸭子、家鸭。。）需要判断鸭子是否能飞（不能飞：子类重写方法）、是否叫声一致
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
        redHeadDuck.fly();

        Duck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.swim();
        mallardDuck.quack();
        mallardDuck.fly();
    }
}
