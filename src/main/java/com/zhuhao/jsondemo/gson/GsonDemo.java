package com.zhuhao.jsondemo.gson;

import com.google.gson.Gson;
import com.zhuhao.jsondemo.fastjsondemo01.Person;
import org.junit.Test;

/**
 * gson 使用
 * @Author halk
 * @Date 2020/9/30 9:53
 */
public class GsonDemo {

    /**
     * 转为json
     */
    @Test
    public void test01(){
        Person person = new Person();
        person.setAge(11);
        person.setId(10);
        person.setName("hong");

        Gson gson = new Gson();
        String json = gson.toJson(person);

        System.out.println(json);

        Person person1 = gson.fromJson(json, Person.class);
        System.out.println(person1);

    }
}
