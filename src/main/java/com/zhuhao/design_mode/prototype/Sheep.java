package com.zhuhao.design_mode.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author halk
 * @Date 2020/11/3 15:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sheep implements Cloneable, Serializable {

    private String name;
    private Integer age;
    private String address;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
