package com.zhuhao.middleware.jsondemo.FASTJsonDemo.FASTJsonTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;

import java.util.*;

/**
 * @author junhi
 * @date 2019/6/20 10:33
 */
public class FastJsonTest {

    /**
     * Java Bean to json
     */
    @Test
    public void JavaBeanToJson(){
        Person person = Person.builder().id(1).name("倪杰").address("合肥").build();
        String str = JSON.toJSONString(person);
        System.out.println(str);

        Person person1 = JSON.parseObject(str, Person.class);
        System.out.println(person1);
    }

    /**
     * List<JavaBean> to json
     */
    @Test
    public void JsonToListBean(){
        Person person1 = Person.builder().id(1).name("倪杰").address("合肥").build();
        Person person2 = Person.builder().id(2).name("倪杰2").address("合肥2").build();
        List<Person> personList = Arrays.asList(person1, person2);
        String str = JSON.toJSONString(personList);
        System.out.println(str);

        List<Person> personList1 = JSON.parseArray(str, Person.class);
        System.out.println(personList1);
    }

    /**
     * Map<String, Object> to json
     */
    @Test
    public void MapToJson(){
//        Map<String, Object> hashMap = new HashMap<>();
        Map<String, Object> hashMap = new LinkedHashMap<>();
        hashMap.put("person1", Person.builder().id(1).name("倪杰").address("合肥").build());
        hashMap.put("person2", Person.builder().id(2).name("倪杰2").address("合肥2").build());
        hashMap.put("person3", Person.builder().id(3).name("倪杰3").address("合肥3").build());
        String str = JSON.toJSONString(hashMap);
        System.out.println(str);

        Map<String, Object> objectMap = JSON.parseObject(str, new TypeReference<Map<String, Object>>() {});
        objectMap.forEach((x,y) -> System.out.println(x + ":\t" + y));


    }
}
