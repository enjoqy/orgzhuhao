package com.zhuhao.design_mode.builder_pattern.homeworke;

/**
 * @Author halk
 * @Date 2020/11/5 15:39
 */
public interface PersonBuilder {

    void setEye();

    void setFace();

    void setBody();

    Person build();
}
