package com.zhuhao.design_mode.decorator.d;

/**
 * 调料类
 *
 * 判断两个类之间能不能有继承关系，主要看这两个类之间有没有“is a”关系。并且还要符合里氏替换原则，
 * 以上只是原则，不是语法强制。特定情况下可以违反这个原则，装饰器模式中就是这样。
 * 尽管调料不是饮料，为了制作装饰器模式，也只能让调料去继承饮料。
 *
 * @Author halk
 * @Date 2020/11/7 16:35
 */
public abstract class Condiment extends Beverage {

    /**
     * 让调料类关联饮料类
     */
    protected Beverage beverage;

    public Condiment(Beverage beverage) {
        super("调料");
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 0;
    }
}
