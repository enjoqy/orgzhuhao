package com.zhuhao.design_mode.decorator.a;

/**
 * Espresso浓缩咖啡
 *
 * @Author halk
 * @Date 2020/11/6 13:56
 */
public class Espresso extends Beverage {

    public Espresso() {
        super("Espresso浓缩咖啡");
    }

    @Override
    public double cost() {
        return 2;
    }
}
