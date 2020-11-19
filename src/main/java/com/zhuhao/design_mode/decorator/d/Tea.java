package com.zhuhao.design_mode.decorator.d;

/**
 * @Author halk
 * @Date 2020/11/6 16:04
 */
public class Tea extends Beverage {
    public Tea() {
        super("tea 茶...");
    }

    @Override
    public double cost() {
        return 20;
    }
}
