package com.zhuhao.design_mode.builder_pattern.homeworke;

/**
 * 男神
 *
 * @Author halk
 * @Date 2020/11/5 15:44
 */
public class MaleGodBuilder implements PersonBuilder {

    private Person person = new Person();

    @Override
    public void setEye() {
        person.setEye("大眼睛");
    }

    @Override
    public void setFace() {
        person.setFace("吴彦祖");
    }

    @Override
    public void setBody() {
        person.setBody("壮硕");
    }

    @Override
    public Person build() {
        return person;
    }
}
