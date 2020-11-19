package com.zhuhao.design_mode.proxy.a;

/**
 * @Author halk
 * @Date 2020/11/13 14:44
 */
public class ICalcImpl implements ICalc {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public int mul(int a, int b) {
        return a * b;
    }

    @Override
    public int div(int a, int b) {
        return a / b;
    }
}
