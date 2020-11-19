package com.zhuhao.design_mode.proxy.a;

/**
 * @Author halk
 * @Date 2020/11/13 14:41
 */
public interface ICalc {

    int add(int a, int b);

    /**
     * subtract 减
     * @return
     */
    int sub(int a, int b);

    /**
     * multiply 乘
     * @return
     */
    int mul(int a, int b);

    /**
     * divide 除
     * @return
     */
    int div(int a, int b);
}
