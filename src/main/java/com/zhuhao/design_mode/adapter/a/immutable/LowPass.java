package com.zhuhao.design_mode.adapter.a.immutable;

import com.zhuhao.design_mode.adapter.a.StringProcessor;

/**
 * 低通滤波
 *
 * @Author halk
 * @Date 2020/11/11 11:02
 */
public class LowPass extends Filter {
    double cutOff;

    public LowPass(double cutOff) {
        this.cutOff = cutOff;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
