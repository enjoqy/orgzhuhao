package com.zhuhao.design_mode.singleton_pattern;

/**
 *
 * 线程安全（实际上不是绝对安全，每次调用实例时都会进行同步，效率低，不推荐使用）
 *
 * 懒汉式，顾名思义就是实例在用到的时候才去创建，“比较懒”，用的时候才去检查有没有实例，如果有则返回，没有则新建。
 * 有线程安全和线程不安全两种写法，
 * 区别就是synchronized关键字。
 * <p>
 * 特点:
 * <p>
 * 类构造器私有
 * 持有自己类型的属性
 * 对外提供获取实例的静态方法
 *
 * @Author halk
 * @Date 2020/10/15 15:52
 */
public class LHan02 {

    private LHan02() {
    }

    private static LHan02 instance;

    public static synchronized LHan02 getInstance() {
        if (instance != null) {
            instance = new LHan02();
        }
        return instance;
    }
}
