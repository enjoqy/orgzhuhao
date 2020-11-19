package com.zhuhao.design_mode.template.b;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 需求：
 * 测试arrayList 和 linkedList 的增加效率(在指定位置插入时)
 *
 * @Author halk
 * @Date 2020/11/9 15:25
 */
public class AppTest {

    public static final native int w();

    /**
     * 此时，每次测试的代码发生变化时，就要修改原有的代码，如果修改之后，又需要测试之前的代码，那么又要把之前的代码写回来
     *
     * 改进：将公共的部分抽取出来，变化的部分让子类重写
     */
    @Test
    public void test01() {

        Template template = new ArrayListTest();
        template.template();

        Template template2 = new LinkedListTest();
        template2.template();

        int[] a = new int[25];
        System.out.println(a);
    }
}
