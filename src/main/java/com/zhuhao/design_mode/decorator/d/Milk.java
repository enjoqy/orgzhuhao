package com.zhuhao.design_mode.decorator.d;

/**
 * 调料：牛奶
 *
 * @Author halk
 * @Date 2020/11/7 16:43
 */
public class Milk extends Condiment {
    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return this.beverage.cost() + 0.2;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + " 牛奶";
    }
}
