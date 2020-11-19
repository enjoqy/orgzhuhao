package com.zhuhao.design_mode.singleton_pattern;

/**
 * 使用枚举可以实现单例
 * 借助jdk1.5中添加的枚举实现单例模式。不仅能避免多线程同步问题，而且还能防止反序列化重新创建对象
 * 推荐使用
 *
 * @Author halk
 * @Date 2020/11/3 9:24
 */
enum  EnumTest {
    /**
     * 属性
     */
    instance;

    public void sayOk(){
        System.out.println("ok~~~");
    }
}
