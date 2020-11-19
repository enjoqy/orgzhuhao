package com.zhuhao.design_mode.adapter.a.immutable;

import com.zhuhao.design_mode.adapter.a.StringProcessor;

/**
 * 高通滤波
 *
 * @Author halk
 * @Date 2020/11/11 11:02
 */
public class HighPass extends Filter {
    double cutOff;

    public HighPass(double cutOff) {
        this.cutOff = cutOff;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
