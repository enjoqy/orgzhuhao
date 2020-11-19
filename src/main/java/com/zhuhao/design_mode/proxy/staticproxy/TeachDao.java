package com.zhuhao.design_mode.proxy.staticproxy;

/**
 * @Author halk
 * @Date 2020/11/17 9:48
 */
public class TeachDao implements ITeachDao {
    @Override
    public void teach() {
        System.out.println("老师开始授课。。。。");
    }
}
