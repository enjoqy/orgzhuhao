package com.zhuhao.design_mode.adapter.a;

/**
 * 转换为小写
 *
 * @Author halk
 * @Date 2020/11/10 17:28
 */
public class Downcase extends StringProcessor {

    @Override
    public Object process(Object input) {
        return String.valueOf(input).toLowerCase();
    }
}
