package com.zhuhao.design_mode.builder_pattern.b;

/**
 * 构建者，建造者类，必须关联电脑产品
 *
 * @Author halk
 * @Date 2020/11/4 16:55
 */
public class ComputerBuilder {

    private Computer computer = new Computer();

    public Computer build(){
        computer.setCpu("i7 10990");
        computer.setGpu("gtx 2020Ti");
        computer.setHd("ssd 1T");
        computer.setMemory("16G");

        return computer;
    }
}
