package com.zhuhao.basic.annotationdemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 仿写JUnit
 *
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 */
public final class MyUnit {

    private MyUnit() {

    }

    public static void run(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            Method[] declaredMethods = clazz.getDeclaredMethods();

            for (Method declaredMethod : declaredMethods) {
                boolean result = declaredMethod.isAnnotationPresent(Test01.class);
                if (result) {
                    declaredMethod.invoke(clazz.newInstance());
                }

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {


    }
}
