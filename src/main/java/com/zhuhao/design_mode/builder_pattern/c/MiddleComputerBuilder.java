package com.zhuhao.design_mode.builder_pattern.c;

/**
 * 构建者，建造者类，必须关联电脑产品
 *
 * @Author halk
 * @Date 2020/11/4 16:55
 */
public class MiddleComputerBuilder {

    private Computer computer = new Computer();

    public Computer build(){
        computer.setCpu("i5 10990");
        computer.setGpu("gtx 1020Ti");
        computer.setHd("ssd 500G");
        computer.setMemory("16G");

        return computer;
    }
}
