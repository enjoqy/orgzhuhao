package com.zhuhao.threaddemo;

/**
 * 定义一个账户类
 *
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 */
public class Acount {

    private int acount = 500;

    public int getAcount() {
        return acount;
    }

    public void less(int a) {
        this.acount = this.acount - a;

    }


}
