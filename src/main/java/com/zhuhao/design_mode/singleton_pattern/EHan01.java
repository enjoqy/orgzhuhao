package com.zhuhao.design_mode.singleton_pattern;

/**
 *
 *
 *
 * 饿汉式：类初始化的时候就会创建实例
 * 弊端：因为类加载的时候就会创建对象，所以有的时候还不需要使用对象，就会创建对象，造成内存的浪费；
 *
 * @Author halk
 * @Date 2020/10/15 15:55
 */
public class EHan01 {

    private EHan01() {
    }

    private  final static EHan01 instance = new EHan01();

    public static EHan01 getInstance() {
        return instance;
    }

}


