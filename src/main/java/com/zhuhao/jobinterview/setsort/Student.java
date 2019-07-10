package com.zhuhao.jobinterview.setsort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 需要对这个实体类进行自然排序，需要实现Comparable接口
 * @author junhi
 * @date 2019/7/10 19:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student implements Comparable<Student> {

    private String name;
    private int age;

    @Override
    public int compareTo(Student o) {
        //按照年龄排序
        return this.age - o.age;
    }
}
