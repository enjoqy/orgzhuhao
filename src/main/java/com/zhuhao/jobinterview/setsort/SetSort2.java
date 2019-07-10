package com.zhuhao.jobinterview.setsort;

import org.junit.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 2**.选择器排序：也就是在创建Set集合对象时给他=它一个选择器，也就是构造函数传参（传一个Comparator的子对象），
 * 给集合一个选择排序的标准，具体如何凭借什么选择就看重写Comparator的方法逻辑是怎样实现的**
 *
 * @author junhi
 * @date 2019/7/10 19:41
 */
public class SetSort2 {

    /**
     * 选择器排序，创建集合时，构造函数传参，使用匿名内部类实现Comparable接口
     */
    @Test
    public void test01(){
        //创建集合对象
        Set<Student2> tree = new TreeSet<>(
                //匿名内部类定义匿名对象
                new Comparator<Student2>() {
                    @Override
                    public int compare(Student2 o1, Student2 o2) {
                        //按年龄排序
                        return o1.getAge() - o2.getAge();
                    }
                });
        Student2 s1 = new Student2("霍建华",15);
        Student2 s2 = new Student2("王亚妮",35);
        Student2 s3 = new Student2("张三疯",25);
        tree.add(s1);
        tree.add(s2);
        tree.add(s3);
        //遍历
        tree.forEach((x) -> System.out.println(x));
    }

}
