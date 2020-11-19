package com.zhuhao.design_mode.builder_pattern.d;

/**
 * @Author halk
 * @Date 2020/11/4 17:33
 */
public interface ComputerBuild {

    void setCpu();
    void setGpu();
    void setMemory();
    void setHd();

    Computer build();
}
