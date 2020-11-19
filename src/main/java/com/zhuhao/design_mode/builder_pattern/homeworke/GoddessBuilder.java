package com.zhuhao.design_mode.builder_pattern.homeworke;

/**
 * @Author halk
 * @Date 2020/11/5 15:47
 */
public class GoddessBuilder implements PersonBuilder{

    private Person person = new Person();

    @Override
    public void setEye() {
        person.setEye("圆眼睛");
    }

    @Override
    public void setFace() {
person.setFace("刘亦菲");
    }

    @Override
    public void setBody() {
person.setBody("丰满匀称");
    }

    @Override
    public Person build() {
        return person;
    }
}
