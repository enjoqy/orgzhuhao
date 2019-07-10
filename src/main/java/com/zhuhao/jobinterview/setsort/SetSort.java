package com.zhuhao.jobinterview.setsort;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

/**
 * 1**.自然排序：也就是自然发生的，在创建集合对象时不需要给参数。注：往TreeSet集合对象中添加元素是，
 * 元素必须是可比的（Integer 、Double、Float….），假如是自定义类型Student，就必须让Student实现Comparable接口**
 *
 * @author junhi
 * @date 2019/7/10 19:18
 */
public class SetSort {

    /**
     * 自然排序，对自定义类型就行排序，需要实现Comparable接口
     */
    @Test
    public void test01(){
        //创建集合对象
        Set<Student> tree = new TreeSet<>();
        //创建元素
        Student s1 = Student.builder().age(18).name("倪杰").build();
        Student s2 = Student.builder().age(30).name("张涛").build();
        Student s3 = Student.builder().age(12).name("小明明").build();
        //将元素添加到tree中  注：给TreeSet添加对象时，对象必须是可比的（即实现了Comparable接口），
        // 要是不是可比的就不知道讲当前对象放在什么位置
        tree.add(s1);
        tree.add(s2);
        tree.add(s3);

        tree.forEach((x) -> System.out.println(x));
    }

    /**
     * 对8中包装类型进行排序
     */
    @Test
    public void test02(){
        //创建集合对象
        Set<Integer> tree = new TreeSet<>();
        tree.add(1);
        tree.add(6);
        tree.add(2);
        tree.forEach((x) -> System.out.println(x));

        //创建集合对象
        Set<String> tree2 = new TreeSet<>();
        tree2.add("你好");
        tree2.add("你");
        tree2.add("好");
        tree2.forEach((x) -> System.out.println(x));
    }



}
