package com.zhuhao.design_mode.adapter.a;

/**
 * 处理器
 *
 * @Author halk
 * @Date 2020/11/10 17:20
 */
public interface Processor {

    String name();

    Object process(Object input);
}
