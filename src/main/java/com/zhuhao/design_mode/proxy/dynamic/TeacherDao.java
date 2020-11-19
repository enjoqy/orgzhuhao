package com.zhuhao.design_mode.proxy.dynamic;

/**
 * @Author halk
 * @Date 2020/11/17 17:13
 */
public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("teacher ....");
    }

    @Override
    public void name() {
        System.out.println("i am xiaohong");
    }
}
