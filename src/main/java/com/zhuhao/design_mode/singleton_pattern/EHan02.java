package com.zhuhao.design_mode.singleton_pattern;

/**
 *
 * 静态代码块
 *
 * 饿汉式：类初始化的时候就会创建实例
 * 弊端：因为类加载的时候就会创建对象，所以有的时候还不需要使用对象，就会创建对象，造成内存的浪费；
 *
 * @Author halk
 * @Date 2020/10/15 15:55
 */
public class EHan02 {

    private EHan02() {
    }

    private  final static EHan02 instance;

    static {
        instance = new EHan02();
    }

    public static EHan02 getInstance() {
        return instance;
    }

}


