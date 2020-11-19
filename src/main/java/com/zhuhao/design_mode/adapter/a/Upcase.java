package com.zhuhao.design_mode.adapter.a;

/**
 * 转换成大写
 *
 * @Author halk
 * @Date 2020/11/10 17:25
 */
public class Upcase extends StringProcessor {

    @Override
    public Object process(Object input) {
        return String.valueOf(input).toUpperCase();
    }
}
