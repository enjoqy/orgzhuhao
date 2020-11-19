package com.zhuhao.design_mode.builder_pattern.e;

/**
 * 构建者，建造者类，必须关联电脑产品
 *
 * @Author halk
 * @Date 2020/11/4 16:55
 */
public class LowComputerBuilder implements ComputerBuild {
    private Computer computer = new Computer();

    @Override
    public void setCpu() {
        computer.setCpu("i3 9300");
    }

    @Override
    public void setGpu() {
        computer.setGpu("gtx 980");
    }

    @Override
    public void setMemory() {
        computer.setMemory("8G");
    }

    @Override
    public void setHd() {
        computer.setHd("hd 1T");
    }

    @Override
    public Computer build() {
        return computer;
    }
}
