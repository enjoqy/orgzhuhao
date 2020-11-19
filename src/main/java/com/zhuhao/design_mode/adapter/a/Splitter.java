package com.zhuhao.design_mode.adapter.a;

import java.util.Arrays;

/**
 * 分割字符串
 *
 * @Author halk
 * @Date 2020/11/10 17:31
 */
public class Splitter extends StringProcessor {
    @Override
    public Object process(Object input) {
        return Arrays.toString(String.valueOf(input).split(" "));
    }
}
