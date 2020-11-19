package com.zhuhao.jsondemo.FASTJsonDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * JSON操作设计到的类
 *
 * @author: zhuhao
 * @date: 2019/4/8 0008 19:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
    private int id;
    private String name;
    private ArrayList<Student> stus;
}
