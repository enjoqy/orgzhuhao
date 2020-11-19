package com.zhuhao.design_mode.singleton_pattern;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author halk
 * @Date 2020/11/2 16:55
 */
public class SingletonTest {


    @Test
    public void test01(){
        EHan01 instance = EHan01.getInstance();
        EHan01 instance2 = EHan01.getInstance();
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());

    }

    @Test
    public void test02(){
        EHan02 instance = EHan02.getInstance();
        EHan02 instance2 = EHan02.getInstance();
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());

    }

    @Test
    public void test03() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {

        StaticInnerClass instance = StaticInnerClass.getInstance();

        Constructor<StaticInnerClass> declaredConstructor = StaticInnerClass.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        StaticInnerClass instance1 = declaredConstructor.newInstance();

        System.out.println(instance == instance1);
    }

    @Test
    public void test04(){
        EnumTest instance = EnumTest.instance;
        EnumTest instance2 = EnumTest.instance;
        instance.sayOk();
    }
}
