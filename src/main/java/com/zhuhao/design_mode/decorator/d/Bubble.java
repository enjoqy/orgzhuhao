package com.zhuhao.design_mode.decorator.d;

/**
 * 调料：泡沫
 *
 * @Author halk
 * @Date 2020/11/7 16:43
 */
public class Bubble extends Condiment {
    public Bubble(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return this.beverage.cost() + 0.2;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + " 泡沫";
    }
}
