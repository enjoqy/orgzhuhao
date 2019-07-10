package com.zhuhao.jobinterview.setsort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *  这里使用lambda表达式来代替匿名内部类,并且使用list接口下的sort方法(java8新增加),再链式输出
 *
 * @author junhi
 * @date 2019/7/10 19:50
 */
public class SetSort3 {

    private List<Student2> student2List = Arrays.asList(
            new Student2("jack",19),
            new Student2("jack2",17),
            new Student2("jack",17),
            new Student2("jessica",25),
            new Student2("tommy",23),
            new Student2("apple",25),
            new Student2("jack",18)
    );

    /**
     * 根据User年龄从小到大排序,使用Collections.sort方法,通过Comparator的匿名内部类实现
     */
    @Test
    public void test01(){
        Collections.sort(student2List, new Comparator<Student2>() {
            @Override
            public int compare(Student2 o1, Student2 o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        student2List.forEach(x -> System.out.println(x));
    }

    /**
     * 使用lambda表达式来代替匿名内部类,并且使用list接口下的sort方法(java8新增加),再链式输出
     */
    @Test
    public void test02(){
        student2List.sort((o1, o2) -> o1.getAge() - o2.getAge());
        student2List.forEach(x -> System.out.println(x));

    }
}
