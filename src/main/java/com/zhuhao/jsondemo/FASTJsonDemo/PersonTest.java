package com.zhuhao.jsondemo.FASTJsonDemo;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonTest {

    public static void main(String[] args) {
        test01();
    }

    public static void test02() {
        Person person = new Person("蓝鸟", 12, new Date());
        String s = JSON.toJSONString(person);
        System.out.println(s);
        Person person1 = JSON.parseObject(s, Person.class);
        System.out.println(person1);
    }

    public static void test01() {
        List<Person> listOfPerson = new ArrayList<>();
        listOfPerson.add(new Person("蓝蓝", 12, new Date()));
        listOfPerson.add(new Person("红红", 42, new Date()));
        String s = JSON.toJSONString(listOfPerson);
        System.out.println(s);

        listOfPerson.forEach((x) -> {
            System.out.println(x.getFullName());
            System.out.println(x.getAge());
            System.out.println(x.getDateOfBirth());
        });


    }
}
