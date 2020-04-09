package com.zhuhao.lambdademo.lambda;

import com.zhuhao.lambdademo.entity.Student;
import com.zhuhao.lambdademo.entity.Teacher;

import java.util.function.Function;

public class PersonFactory implements Function<String, Object> {

    @Override
    public Object apply(String type) {
        switch (type) {
            case "student":
                return new Student("nijie");
            case "teacher":
                return new Teacher("方俊杰");
            default:
                return null;
        }
    }
}
