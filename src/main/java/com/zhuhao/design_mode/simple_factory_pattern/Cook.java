package com.zhuhao.design_mode.simple_factory_pattern;

/**
 * 工厂模式分为简单工厂模式，工厂模式，抽象工厂模式
 * <p>
 * 在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。
 * 本质就是使用工厂方法代替 new 操作。
 * <p>
 * 简单地说，简单工厂模式通常就是这样，一个工厂类 XxxFactory，里面有一个静态方法，根据我们不同的参数，
 * 返回不同的派生自同一个父类（或实现同一接口）的实例对象
 * <p>
 * 我们强调职责单一原则，一个类只提供一种功能，FoodFactory 的功能就是只要负责生产各种 Food
 * <p>
 * 在此例中可以看出，Cook 类在使用 FoodFactory 时就不需要 new 任何一个对象，这就是简单工厂模式的好处，
 * 封装了 new 的部分，做到的代码易用性。
 *
 * @Author halk
 * @Date 2020/10/15 15:02
 */
public class Cook {

    public static void main(String[] args) {
        Food chicken = FoodFactory.makeFood("兰州拉面");
        System.out.println(chicken.getName());

        Food noodle = FoodFactory.makeFood("黄焖鸡");
        System.out.println(noodle.getName());
    }
}
