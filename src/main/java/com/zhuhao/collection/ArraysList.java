package com.zhuhao.collection;

import org.junit.Test;

import java.util.*;

/**
 * 集合去重，交集，并集
 * @author junhi
 * @date 2019/11/1 11:31
 */
public class ArraysList {

    /**
     * @Author halk
     * @Description 测试isEmpty（）
     * @Date 2020/1/18 12:53
     * @Param []
     * @return void
     **/
    @Test
    public void test03(){
        List<Object> list = new ArrayList<>();
        if (list.isEmpty()){
            System.out.println(list.size());
        }
    }

    /**
     * @Author halk
     * @Description 集合去重 
     * @Date 2020/3/24 9:29
     * @Param []
     * @return void
     **/
    @Test
    public void test02(){
        List<String> A = new ArrayList<>();
        A.add("A");
        A.add("B");
        A.add("哈哈");
        A.add("B");
        A.add("C");
        A.add("D");
        A.add("D");
        A.add("你好");

        Set<String> set = new LinkedHashSet<>();
        set.addAll(A);
        A.clear();
        A.addAll(set);
        System.out.println(A);
    }

    @Test
    public void test01(){
        List<String> A = new ArrayList<>();
        A.add("A");
        A.add("B");
        A.add("C");
        A.add("D");
        List<String> B = new ArrayList<>();
        B.add("C");
        B.add("D");
        B.add("E");
        B.add("F");
        List<String> C = new ArrayList<>();
        A.removeAll(B);
        System.out.println(A);

        C.addAll(A);
        C.retainAll(B);
        System.out.println(C);

        C.add("E");
        C.add("F");
        C.add("G");
        C.add("H");
        C.addAll(A);
        System.out.println(C);

        C.removeAll(B);
        System.out.println(C);
    }
}
