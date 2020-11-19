package com.zhuhao.design_mode.strategy.d.quackbehavior;

/**
 * @Author halk
 * @Date 2020/11/12 15:46
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("静默，不会叫。。");
    }
}
