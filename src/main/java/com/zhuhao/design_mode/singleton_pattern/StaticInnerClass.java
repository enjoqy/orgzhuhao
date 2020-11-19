package com.zhuhao.design_mode.singleton_pattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * 静态内部类，可以通过反射进行获取构造函数，解决方案是在构造函数中加一个判断
 * @Author halk
 * @Date 2020/10/16 17:21
 */
public class StaticInnerClass {

    private StaticInnerClass(){
        if(SingletonHolder.instance != null){
            throw new RuntimeException("  单例不允许有多个实例");
        }
    }

    private static class SingletonHolder {
        private static final StaticInnerClass instance = new StaticInnerClass();
    }

    public static StaticInnerClass getInstance(){
        return SingletonHolder.instance;
    }
}
