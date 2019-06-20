package com.zhuhao.jsondemo.FASTJsonDemo.FASTJsonTest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author junhi
 * @date 2019/6/20 10:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    private int id;
    private String name;
    private String address;
}
