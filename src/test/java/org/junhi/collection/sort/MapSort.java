package org.junhi.collection.sort;

import org.junit.Test;

import java.util.*;

/**
 * @Author halk
 * @Date 2020/1/14 10:59
 */
public class MapSort {


    @Test
    public void test01(){
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);

        map.put(1,8);

        Set<Object> set = map.keySet();
        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next + ":" + map.get(next));
        }
    }
}
