package com.zhuhao.middleware.jsondemo.FASTJsonDemo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @author: zhuhao
 * @date: 2019/4/8 0008 17:19
 */
@Data
public class Person {

    @JSONField(name = "FULL NAME", ordinal = 1)  // serialize = false可以反序列化
    private String fullName;

    @JSONField(name = "AGE", ordinal = 2)
    private int age;

    @JSONField(name = "DATE OF BIRTH", format = "yyyy/MM/dd HH:mm:ss", ordinal = 3)
    private Date dateOfBirth;

    public Person(String fullName, int age, Date dateOfBirth) {
        this.fullName = fullName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


}
