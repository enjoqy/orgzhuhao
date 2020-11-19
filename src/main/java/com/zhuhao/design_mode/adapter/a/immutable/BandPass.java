package com.zhuhao.design_mode.adapter.a.immutable;

/**
 * 带通滤波
 *
 * @Author halk
 * @Date 2020/11/11 11:02
 */
public class BandPass extends Filter {
    /**
     * 中断
     */
    double lowCutoff, highCutoff;

    public BandPass(double lowCutoff, double highCutoff) {
        this.lowCutoff = lowCutoff;
        this.highCutoff = highCutoff;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
