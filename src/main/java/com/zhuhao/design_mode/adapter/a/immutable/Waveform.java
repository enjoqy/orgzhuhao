package com.zhuhao.design_mode.adapter.a.immutable;

/**
 * 电子滤波器
 *
 * @Author halk
 * @Date 2020/11/11 10:51
 */
public class Waveform {
    private static long count;
    private final long id = count++;

    @Override
    public String toString() {
        return "Waveform{" +
                "id=" + id +
                '}';
    }
}
