package com.zhuhao.design_mode.builder_pattern.e;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author halk
 * @Date 2020/11/4 16:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Computer {

    private String cpu;
    private String gpu;
    private String hd;
    private String memory;

}
