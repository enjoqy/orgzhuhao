package com.zhuhao.design_mode.builder_pattern.e;

import org.junit.Test;

/**
 * 需求：定义一个电脑类，并且实例化出电脑类的对象，以及给该电脑类的属性赋值
 * <p>
 * 针对d包中的问题，修改如下：
 * 1.增加一个指挥者角色，用来指挥建造者来建造
 *
 * @Author halk
 * @Date 2020/11/4 16:25
 */
public class BuilderTest {

    /**
     * 目前这种写法是建造者模式，
     * <p>
     * 目前优点：
     * 1。创建对象的过程稳定不变（因为有ComputerBuilder接口来稳定过程）
     * 2。创建过程只写了一次，没有重复代码（指挥者完成）
     * 3.当需要扩展建造者的时候，不需要修改之前的代码，这符合了开闭原则
     * <p>
     * <p>
     * 设计模式的7大原则：
     * 单一职责（类，方法），
     * 接口隔离（接口），
     * 里氏替换（类继承，最好不要重写，可用接口或抽象类实现），
     * 开闭原则（对使用者关，对生产者开，新修改或者增加的代码不能影响以前的代码或使用）
     * 合成服用原则（减少重复代码，尽量用以前的）
     * 依赖倒转（应该依赖高层不要依赖底层，参数声明最好用统一接口或者统一抽象类）
     * 迪米特法则（最少知道原则，对于一个类的或者方法的内部实现最好封装起来，调用着不想知道）
     * 设计原则的核心思想就是：面对接口编程、解耦合、找出代码中可能变化的地方单独抽出来不要和那些不许变化的代码混在一起
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

        //创建指挥者
        Direct direct = new Direct();

        //玩游戏的配置
        Computer computer = direct.build(advancedComputerBuilder);
        System.out.println(computer);

        //开发
        Computer computer2 = direct.build(middleComputerBuilder);
        System.out.println(computer2);

        //办公
        Computer computer3 = direct.build(lowComputerBuilder);
        System.out.println(computer3);
    }
}
