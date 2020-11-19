package com.zhuhao.design_mode.adapter.a.immutable;

/**
 * @Author halk
 * @Date 2020/11/11 11:00
 */
public class Filter {
    public String name() {
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform input){
        return input;
    }

}
