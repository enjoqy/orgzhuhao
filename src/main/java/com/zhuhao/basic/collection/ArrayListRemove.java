package com.zhuhao.basic.collection;

import java.util.ArrayList;

/**
 * @author junhi
 * @date 2019/11/6 21:32
 */
public class ArrayListRemove {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("c");
        list.add("c");
        remove(list);

        for (String s : list) {
            System.out.println("element : " + s);
        }
    }

    public static void remove(ArrayList<String> list) {
        // TODO:
        for (int i = list.size() - 1; i >= 0; i--) {
            String s = list.get(i);
            if (s.equals("b")) {
                list.remove(s);
            }
        }
    }
}
