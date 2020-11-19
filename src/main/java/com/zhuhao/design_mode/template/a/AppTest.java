package com.zhuhao.design_mode.template.a;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 需求：
 * 测试arrayList 和 linkedList 的增加效率(在指定位置插入时)
 *
 * @Author halk
 * @Date 2020/11/9 15:25
 */
public class AppTest {

    /**
     * 此时，每次测试的代码发生变化时，就要修改原有的代码，如果修改之后，又需要测试之前的代码，那么又要把之前的代码写回来
     */
    @Test
    public void test01() {
        System.out.println("begin");
        long begin = System.currentTimeMillis();

//        List<Integer> list = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(0, i);
        }

        long end = System.currentTimeMillis();
        System.out.println("end " + (end - begin));
    }
}
