package com.zhuhao.middleware.jsondemo.fastjsondemo01;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PersonTest {

    public static void test01() {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "小明", 18));
        list.add(new Person(2, "小红", 25));
        list.add(new Person(3, "小李", 30));
        String s = JSON.toJSONString(list);
        System.out.println(s);
    }

    public static void test02() {
        Person person = new Person(1, "111", 22);
        String s = JSON.toJSONString(person);
        System.out.println(s);

        JSONObject jsonObject = JSONObject.parseObject(s);
        System.out.println(jsonObject);

        String name = jsonObject.getString("NAME");
        Integer id = jsonObject.getInteger("ID");
        System.out.println(id + " " + name);

        Person person1 = JSONObject.parseObject(s, Person.class);
        System.out.println(person1);
    }

    public static void main(String[] args) {
        test02();
    }
}
