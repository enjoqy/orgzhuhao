package com.zhuhao.design_mode.decorator.d;

/**
 * decaf低咖啡因
 *
 * @Author halk
 * @Date 2020/11/6 13:54
 */
public class Decaf extends Beverage {
    public Decaf() {
        super("decaf低咖啡因");
    }

    @Override
    public double cost() {
        return 1;
    }
}
