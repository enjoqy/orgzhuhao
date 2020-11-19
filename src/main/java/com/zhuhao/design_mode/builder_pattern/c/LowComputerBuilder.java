package com.zhuhao.design_mode.builder_pattern.c;

/**
 * 构建者，建造者类，必须关联电脑产品
 *
 * @Author halk
 * @Date 2020/11/4 16:55
 */
public class LowComputerBuilder {

    private Computer computer = new Computer();

    public Computer build(){
        computer.setCpu("i3 9300");
        computer.setGpu("gtx 980");
        computer.setHd("hd 1T");
        computer.setMemory("8G");

        return computer;
    }
}
