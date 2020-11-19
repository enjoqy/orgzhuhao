package com.zhuhao.design_mode.adapter.a;


/**
 * 这个抽象方法的作用是，抽取DownCase、UpCase、Splitter中公共的方法name()
 * @Author halk
 * @Date 2020/11/11 14:38
 */
public abstract class StringProcessor implements Processor {
    @Override
    public String name() {
        return getClass().getSimpleName();
    }
}
