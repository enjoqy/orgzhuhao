package com.zhuhao.design_mode.proxy.a;


import org.junit.Test;

/**
 * @Author halk
 * @Date 2020/11/13 10:32
 */
public class AppTest {

    /**
     * 创建代理对象
     *
     * 1.第一个参数：classLoader
     * 我们都知道：要实例化一个对象，是需要调用类的构造器的，在程序运行期间第一次调用构造器时，就会引起类的加载
     * 加载类的时候就是jvm拿着ClassLoader去加载类的字节码，只有字节码被加载到了内存中，才能进一步实例化出类的对象
     * 简单来说，就是只要涉及实例化类的对象，就一定要加载类的字节码，而加载字节码就必须使用类加载器！
     * 下面我们使用动态代理的api来创建一个类的对象
     *
     *
     */
    @Test
    public void test02(){

        ClassLoader cl = AppTest.class.getClassLoader();

//        Proxy.newProxyInstance(cl, )
    }

    @Test
    public void test01(){
        ICalcImpl calc = new ICalcImpl();
        System.out.println(calc.add(1, 2));
        System.out.println(calc.sub(1, 2));
        System.out.println(calc.mul(1, 2));
        System.out.println(calc.div(2, 2));
    }
}
