package com.zhuhao.design_mode.template.b;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author halk
 * @Date 2020/11/9 16:35
 */
public class LinkedListTest extends Template {
    @Override
    void code() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(0, i);
        }
    }
}
