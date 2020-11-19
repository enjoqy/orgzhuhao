package com.zhuhao.design_mode.singleton_pattern;

/**
 *
 * 双重检查，可以保证线程安全、解决效率低的问题
 *
 * @Author halk
 * @Date 2020/11/2 17:19
 */
public class DoubleCheck {

    private DoubleCheck(){}

    private static volatile DoubleCheck instance;

    public DoubleCheck getInstance(){
        if (null == instance){
            synchronized (DoubleCheck.class){
                if (null == instance){
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }
}
