package com.zhuhao.design_mode.builder_pattern.homeworke;

/**
 * @Author halk
 * @Date 2020/11/5 15:55
 */
public class ClownBuilder implements PersonBuilder {
    private Person person = new Person();

    @Override
    public void setEye() {
        person.setEye("细而长");
    }

    @Override
    public void setFace() {
        person.setFace("小丑");
    }

    @Override
    public void setBody() {
        person.setBody("短小精悍");
    }

    @Override
    public Person build() {
        return person;
    }
}
