package com.zhuhao.design_mode.strategy.c;

import org.junit.Test;

/**
 * 针对b包中的问题：
 * 后期加入各种鸭子的时候（木头鸭子、家鸭。。）需要判断鸭子是否能飞（不能飞：子类重写方法）、是否叫声一致，工作量过大
 * <p>
 * 我们希望那些不会飞的鸭子，压根就没有fly方法，不会叫的鸭子压根就没有quack方法
 *
 * 把这两个经常在父类中变化的方法，从父类中抽取出来，分成两个接口：QuackAble、FlyAble
 *
 * @Author halk
 * @Date 2020/11/11 16:48
 */
public class AppTest {

    /**
     * 还是存在问题：
     * 以前是：每加入一个新鸭子，就要判断是否会飞、是否会叫，不会飞就重写飞方法、不会叫就重写叫方法
     * 现在是：每加入一个新鸭子，就要判断是否会飞、是否会叫，不会飞就不实现FlyAble接口，不会叫就不实现QuackAble接口
     *
     * 工作量并没有减少，仍然需要判断新鸭子角色、
     * fly方法和quack方法没有重用性可言，如果有100中鸭子需要飞就需要实现100次飞的方法
     *
     *
     */
    @Test
    public void test01() {
        RedHeadDuck redHeadDuck = new RedHeadDuck();
        redHeadDuck.display();
        redHeadDuck.quack();
        redHeadDuck.swim();
        redHeadDuck.fly();

        MallardDuck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.swim();
        mallardDuck.quack();
        mallardDuck.fly();

        RubberDuck rubberDuck = new RubberDuck();
//        rubberDuck.fly(); 不能飞
        rubberDuck.display();
        rubberDuck.quack();
        rubberDuck.swim();
    }
}
