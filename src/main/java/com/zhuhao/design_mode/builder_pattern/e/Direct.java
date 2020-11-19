package com.zhuhao.design_mode.builder_pattern.e;

/**
 * 指挥者
 *
 * @Author halk
 * @Date 2020/11/5 11:06
 */
public class Direct {
    public Computer build(ComputerBuild cb) {
        cb.setCpu();
        cb.setGpu();
        cb.setMemory();
        cb.setHd();
        return cb.build();
    }
}
