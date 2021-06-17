package com.zhuhao.middleware.jsondemo.fastjsondemo01;

import com.alibaba.fastjson.annotation.JSONField;

public class Person {

    @JSONField(name = "ID", ordinal = 1)
    private int id;
    @JSONField(name = "NAME", ordinal = 2)
    private String name;
    @JSONField(name = "AGE", ordinal = 3)
    private int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
