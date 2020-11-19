package com.zhuhao.design_mode.decorator.a;

import org.junit.Test;

/**
 * @Author halk
 * @Date 2020/11/6 14:05
 */
public class AppTest {

    /**
     * 目前，这段代码，看起来没有问题
     *
     * 变化来了：
     * 星巴克老板为了提高自身竞争力，提出了新的业务：调料。给制作的咖啡中放入调料：牛奶、豆浆、摩卡。。。
     *
     * 如何设计应对这种变化呢
     */
    @Test
    public void test01(){
        Beverage decaf = new Decaf();
        Beverage darkRoast = new DarkRoast();
        Beverage espresso = new Espresso();
        Beverage houseBlend = new HouseBlend();

        System.out.println(decaf.getDescription() + " : " + decaf.cost());
        System.out.println(darkRoast.getDescription() + " : " + darkRoast.cost());
        System.out.println(espresso.getDescription() + " : " + espresso.cost());
        System.out.println(houseBlend.getDescription() + " : " + houseBlend.cost());
    }
}
