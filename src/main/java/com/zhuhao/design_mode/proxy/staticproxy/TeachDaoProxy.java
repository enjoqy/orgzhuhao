package com.zhuhao.design_mode.proxy.staticproxy;

/**
 * 代理对象，静态代理
 *
 * @Author halk
 * @Date 2020/11/17 9:49
 */
public class TeachDaoProxy implements ITeachDao {

    /**
     * 目标对象，通过接口聚合
     */
    private ITeachDao target;

    /**
     * 构造器
     * @param target
     */
    public TeachDaoProxy(ITeachDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("代理开始、、、、");
        target.teach();
        System.out.println("代理结束");

    }
}
