package com.zhuhao.jobinterview.setsort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义类  注：这个类对象是不可比的
 *
 * @author junhi
 * @date 2019/7/10 19:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student2 {

    private String name;
    private int age;

}
