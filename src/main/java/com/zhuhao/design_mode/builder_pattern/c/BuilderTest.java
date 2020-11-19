package com.zhuhao.design_mode.builder_pattern.c;

import org.junit.Test;

/**
 * 需求：定义一个电脑类，并且实例化出电脑类的对象，以及给该电脑类的属性赋值
 * <p>
 * 针对b包中的问题，修改如下：
 * 1.针对不同的需求，我们需要创建不同的建造者，来分别生产不同配置的产品
 *
 * @Author halk
 * @Date 2020/11/4 16:25
 */
public class BuilderTest {

    /**
     * 目前这种写法还不是建造者模式，
     * <p>
     * 目前优点：
     * 1。可以根据客户端的不同需求，使用不同的建造者来生产产品
     * <p>
     * 目前缺点：
     * 1。多个不同的建造者代码重复
     * 2.建造不稳定，如果在建造过程中漏掉了某一部，编译器也不会报错
     * （建造过程没有统一标准，相当于KFC的制作没有统一标准，漏掉某一部或者顺序错了会导致味道不对）
     * <p>
     * 建造者模式与工厂模式的区别：
     * 工厂模式：直接实例化出一个对象即可
     * 建造者模式：实例化出一个对象之后，还需要给该对象的属性赋值（有的属性赋值顺序还不能乱）
     */
    @Test
    public void test01() {
        //创建者
        AdvancedComputerBuilder advancedComputerBuilder = new AdvancedComputerBuilder();
        MiddleComputerBuilder middleComputerBuilder = new MiddleComputerBuilder();
        LowComputerBuilder lowComputerBuilder = new LowComputerBuilder();

        //玩游戏的配置
        Computer computer = advancedComputerBuilder.build();
        System.out.println(computer);

        //开发
        Computer computer2 = middleComputerBuilder.build();
        System.out.println(computer2);

        //办公
        Computer computer3 = lowComputerBuilder.build();
        System.out.println(computer3);
    }
}
