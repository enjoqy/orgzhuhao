package com.zhuhao.thinking.in.java.staticdemo;

import org.junit.Test;

/**
 *
 * static修饰的字段在内存中只有一份存储空间，不管创建多少实例，都只有一份
 * 修改其他的实例中静态字段，所有的静态字段属性都会跟着改变
 *
 * @Author halk
 * @Date 2020/11/3 22:20
 */
public class StaticDemo {

    @Test
    public void test(){

        Demo.count = 100;

//        Demo demo = Demo.builder().age(11).name("xiaoming").build();
//        Demo demo2 = Demo.builder().age(21).name("honghong").build();

        Demo demo = new Demo();
        demo.setAge(11);
        demo.setName("ming");
        demo.setCount(10);

        Demo demo2 = new Demo();
        demo2.setAge(21);
        demo2.setName("hong");
        demo2.setCount(20);


        System.out.println(demo == demo2);

        System.out.println(demo);
        System.out.println(demo2);
    }

    @Test
    public void test02(){
        System.getProperties().list(System.out);
    }

}



