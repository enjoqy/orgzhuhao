package com.zhuhao.design_mode.builder_pattern.d;

import org.junit.Test;

/**
 * 需求：定义一个电脑类，并且实例化出电脑类的对象，以及给该电脑类的属性赋值
 * <p>
 * 针对c包中的问题，修改如下：
 * 1.创建一个建造者接口，把制作产品的具体步骤，稳定下来
 * 2.建造者去实现接口，接口中的方法步骤，类就必须要实现，少实现一个抽象方法就会报错
 *
 * @Author halk
 * @Date 2020/11/4 16:25
 */
public class BuilderTest {

    /**
     * 目前这种写法还不是建造者模式，
     * <p>
     * 目前优点：
     * 1。建造者的建造过程稳定，不会漏掉某一步，进行扩展时也不会漏某一步骤
     * <p>
     * 目前缺点：
     * 1。多个不同的建造者代码重复
     * 2.想在相当于客户自己配置电脑，违反了迪米特法则（客户不配置电脑，只想要整机，不需要知道装机步骤）
     * （相当于你去电脑城配电脑，虽然不用自己动手组装，但是需要指挥装机boy，该装。。该装。。。该装。。）
     * <p>
     * 建造者模式与工厂模式的区别：
     * 工厂模式：直接实例化出一个对象即可
     * 建造者模式：实例化出一个对象之后，还需要给该对象的属性赋值（有的属性赋值顺序还不能乱）
     */
    @Test
    public void test01() {
        //创建者

        //玩游戏的配置
        AdvancedComputerBuilder advancedComputerBuilder = new AdvancedComputerBuilder();
        advancedComputerBuilder.setCpu();
        advancedComputerBuilder.setGpu();
        advancedComputerBuilder.setMemory();
        advancedComputerBuilder.setHd();
        Computer computer = advancedComputerBuilder.build();
        System.out.println(computer);

        //开发
        MiddleComputerBuilder middleComputerBuilder = new MiddleComputerBuilder();
        middleComputerBuilder.setCpu();
        middleComputerBuilder.setGpu();
        middleComputerBuilder.setMemory();
        middleComputerBuilder.setHd();
        Computer computer2 = middleComputerBuilder.build();
        System.out.println(computer2);

        //办公
        LowComputerBuilder lowComputerBuilder = new LowComputerBuilder();
        lowComputerBuilder.setCpu();
        lowComputerBuilder.setGpu();
        lowComputerBuilder.setMemory();
        lowComputerBuilder.setHd();
        Computer computer3 = lowComputerBuilder.build();
        System.out.println(computer3);
    }
}
