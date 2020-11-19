package com.zhuhao.design_mode.builder_pattern.a;

import org.junit.Test;

/**
 * 需求：定义一个电脑类，并且实例化出电脑类的对象，以及给该电脑类的属性赋值
 *
 * @Author halk
 * @Date 2020/11/4 16:25
 */
public class BuilderTest {

    /**
     * 这样做的缺点是：
     * 1.客户端程序员，在实例化好产品对象时，必须为干对象的每一个属性赋值，这样对于客户端程序员来讲，太麻烦了
     * 2.违反了迪米特法则（最少知道原则，对于客户端程序员来讲，只想要一个实例，不要去想去为属性赋值）
     * <p>
     * 这相当于去电脑城配电脑，商家把零件给你，自己组装电脑
     * <p>
     * 建造者模式与工厂模式的区别：
     * 工厂模式：直接实例化出一个对象即可
     * 建造者模式：实例化出一个对象之后，还需要给该对象的属性赋值（有的属性赋值顺序还不能乱）
     */
    @Test
    public void test01() {
        Computer computer = new Computer();
        computer.setCpu("i7 10990");
        computer.setGpu("gtx 2020Ti");
        computer.setHd("ssd 1T");
        computer.setMemory("16G");

        System.out.println(computer);

        Computer computer2 = new Computer();
        computer2.setCpu("i5 7990");
        computer2.setGpu("gtx 1020Ti");
        computer2.setHd("ssd 500G");
        computer2.setMemory("8G");

        System.out.println(computer2);
    }
}
