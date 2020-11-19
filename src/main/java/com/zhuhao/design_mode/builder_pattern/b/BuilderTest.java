package com.zhuhao.design_mode.builder_pattern.b;

import org.junit.Test;

/**
 * 需求：定义一个电脑类，并且实例化出电脑类的对象，以及给该电脑类的属性赋值
 *
 * 针对a包中的问题：（需要不同配置的电脑需要一个一个的创建）
 * 修改代码如下：
 * 作者：专门创建一个“ComputerBuilder”类，这个类专门负责封装组装电脑的过程
 *
 * @Author halk
 * @Date 2020/11/4 16:25
 */
public class BuilderTest {

    /**
     * 目前这种写法还不是建造者模式，
     *
     * 目前优点：
     * 1。客户端程序员需要产品时，直接向创建者要就可，创建者封装了电脑复杂的组装过程
     *
     * 目前缺点：
     * 1。封装的太狠，无论客户的需求什么，都采用最高配置，这相当于你去电脑城配电脑，无论是什么需求，商家都给最高配
     * <p>
     * 建造者模式与工厂模式的区别：
     * 工厂模式：直接实例化出一个对象即可
     * 建造者模式：实例化出一个对象之后，还需要给该对象的属性赋值（有的属性赋值顺序还不能乱）
     */
    @Test
    public void test01() {
        //创建者
        ComputerBuilder computerBuilder = new ComputerBuilder();

        //玩游戏的配置
        Computer computer = computerBuilder.build();
        System.out.println(computer);

        //开发
        Computer computer2 = computerBuilder.build();
        System.out.println(computer2);

        //办公
        Computer computer3 = computerBuilder.build();
        System.out.println(computer3);
    }
}
