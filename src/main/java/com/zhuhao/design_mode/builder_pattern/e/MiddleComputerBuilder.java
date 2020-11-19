package com.zhuhao.design_mode.builder_pattern.e;

/**
 * 构建者，建造者类，必须关联电脑产品
 *
 * @Author halk
 * @Date 2020/11/4 16:55
 */
public class MiddleComputerBuilder implements ComputerBuild {

    private Computer computer = new Computer();

    @Override
    public void setCpu() {
        computer.setCpu("i5 10990");
    }

    @Override
    public void setGpu() {
        computer.setGpu("gtx 1020Ti");
    }

    @Override
    public void setMemory() {
        computer.setMemory("16G");
    }

    @Override
    public void setHd() {
        computer.setHd("ssd 500G");
    }

    @Override
    public Computer build() {
        return computer;
    }
}
