package com.zhuhao.thinking.in.java.staticdemo;

import lombok.Builder;
import lombok.Data;

/**
 * @Author halk
 * @Date 2020/11/3 22:22
 */
@Data
public class Demo {

    static Integer count = 0;
    private String name;
    private Integer age;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        Demo.count = count;
    }


    @Override
    public String toString() {
        return "Demo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", count=" + count +
                '}';
    }
}
