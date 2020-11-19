package com.zhuhao.design_mode.strategy.d;

import com.zhuhao.design_mode.strategy.d.duck.*;
import com.zhuhao.design_mode.strategy.d.flybehavior.FlyWithWings;
import com.zhuhao.design_mode.strategy.d.quackbehavior.Squeak;
import org.junit.Test;

/**
 * 针对c包中的问题：
 *
 * 是时候把飞行和叫方法，从鸭子中分离出来了（这里的分离与c包中的不一样）
 *
 * @Author halk
 * @Date 2020/11/11 16:48
 */
public class AppTest {

    /**
     *
     */
    @Test
    public void test01() {
        Duck redHeadDuck = new RedHeadDuck();
        redHeadDuck.display();
        redHeadDuck.performFly();
        redHeadDuck.performQuack();
        redHeadDuck.swim();

        System.out.println("--------------");

        Duck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.swim();
        mallardDuck.performQuack();
        mallardDuck.performFly();

        System.out.println("--------------");

        Duck rubberDuck = new RubberDuck();
        rubberDuck.display();
        rubberDuck.performFly();
        rubberDuck.performQuack();
        rubberDuck.swim();

        System.out.println("--------------");

        Duck decoyDuck = new DecoyDuck();
        decoyDuck.display();
        decoyDuck.performFly();
        decoyDuck.performQuack();
        decoyDuck.swim();

        /**
         * 可以在运行期间改变其行为，强大之处
         */
        decoyDuck.setFlyBehavior(new FlyWithWings());
        decoyDuck.setQuackBehavior(new Squeak());
        decoyDuck.performFly();
        decoyDuck.performQuack();
    }
}
