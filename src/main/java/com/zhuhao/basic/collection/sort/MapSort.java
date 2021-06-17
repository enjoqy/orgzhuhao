package com.zhuhao.basic.collection.sort;

import org.junit.Test;

import java.util.*;

/**
 * @Author halk
 * @Date 2020/1/14 11:00
 */
public class MapSort {

    @Test
    public void test02(){
        List<Integer> list = new ArrayList<>(Arrays.asList(112, 2, 3, 5));
        list.forEach(x -> System.out.println(x));
        System.out.println(list.size());
    }

    @Test
    public void test01(){
        Map<String, List> treeMap = new TreeMap<>(
                (o1, o2) -> {
                    String[] splitStr = o1.split(",");
                    String realScoreTotal01 =  splitStr[splitStr.length - 1];

                    String[] splitStr2 = o2.split(",");
                    String realScoreTotal02 = splitStr2[splitStr.length - 1];

                    if (realScoreTotal01.equals(realScoreTotal02)){
                        return -1;
                    }

                    System.out.println(realScoreTotal02.compareTo(realScoreTotal01));

                    return realScoreTotal02.compareTo(realScoreTotal01);
                }
        );

        treeMap.put("南源口中心学校,14.0,3.3000002", new ArrayList());
        treeMap.put("南源口中心学校2,14.0,3.3000002", new ArrayList());
        treeMap.put("www,14.0,3.5", new ArrayList());
        treeMap.put("www2,14.0,3.5", new ArrayList());
        treeMap.put("示范幼儿园2,14.0,7.3", new ArrayList(Arrays.asList(1,2,3)));
        treeMap.put("示范幼儿园,14.0,7.3", new ArrayList(Arrays.asList(1,2,3)));




        treeMap.forEach((x, y) -> System.out.println(x + "\t:\t" + y));

    }
}
