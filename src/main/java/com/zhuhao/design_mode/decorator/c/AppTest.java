package com.zhuhao.design_mode.decorator.c;

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
     * 1.星巴克老板又加入了一种新的调料：枸杞，就要重新改写父类Beverage的getDescription（） 和 cost方法来把枸杞加进去，这样不符合开闭原则
     */
    @Test
    public void test01(){

        Beverage decaf = new Decaf();
        //需要对咖啡加调料时直接设置就行了
        decaf.setMilk(true);
        decaf.setBubble(true);


        Beverage darkRoast = new DarkRoast();
        darkRoast.setSoy(true);
        darkRoast.setBubble(true);

        Beverage espresso = new Espresso();
        Beverage houseBlend = new HouseBlend();
        Beverage tea = new Tea();

        System.out.println(decaf.getDescription() + " : " + decaf.cost() + " : " + decaf.getMilk());
        System.out.println(darkRoast.getDescription() + " : " + darkRoast.cost());
        System.out.println(espresso.getDescription() + " : " + espresso.cost());
        System.out.println(houseBlend.getDescription() + " : " + houseBlend.cost());
        System.out.println(tea.getDescription() + " : " + tea.cost());
    }
}
