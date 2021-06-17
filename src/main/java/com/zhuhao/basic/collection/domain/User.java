package com.zhuhao.basic.collection.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author junhi
 * @date 2019/11/6 19:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String username;
    private Integer age;
    private Double salary;
}
