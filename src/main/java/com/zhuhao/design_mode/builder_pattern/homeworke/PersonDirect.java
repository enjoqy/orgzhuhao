package com.zhuhao.design_mode.builder_pattern.homeworke;

/**
 * 指挥者
 *
 * @Author halk
 * @Date 2020/11/5 15:49
 */
public class PersonDirect {

    public Person build(PersonBuilder pb){
        pb.setEye();
        pb.setFace();
        pb.setBody();

        return pb.build();
    }
}
