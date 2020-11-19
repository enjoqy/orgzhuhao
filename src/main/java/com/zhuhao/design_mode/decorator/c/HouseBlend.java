package com.zhuhao.design_mode.decorator.c;

/**
 * HouseBlend首选咖啡
 *
 * @Author halk
 * @Date 2020/11/6 13:58
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        super("HouseBlend首选咖啡");
    }

    @Override
    public double cost() {
        return 5 + super.cost();
    }
}
