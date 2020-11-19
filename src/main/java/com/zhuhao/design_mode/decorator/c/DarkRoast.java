package com.zhuhao.design_mode.decorator.c;

/**
 * DarkRoast焦炒咖啡
 *
 * @Author halk
 * @Date 2020/11/6 13:57
 */
public class DarkRoast extends Beverage {
    public DarkRoast() {
        super("DarkRoast焦炒咖啡");
    }

    @Override
    public double cost() {
        return 3 + super.cost();
    }
}
