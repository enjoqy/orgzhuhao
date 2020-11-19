package com.zhuhao.design_mode.template.b;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author halk
 * @Date 2020/11/9 16:34
 */
public class ArrayListTest extends Template {
    @Override
    void code() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(0, i);
        }
    }
}
