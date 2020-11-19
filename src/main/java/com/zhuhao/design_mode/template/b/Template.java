package com.zhuhao.design_mode.template.b;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author halk
 * @Date 2020/11/9 16:32
 */
public abstract class Template {

    public void template() {
        System.out.println("begin");
        long begin = System.currentTimeMillis();

        code();

        long end = System.currentTimeMillis();
        System.out.println("end " + (end - begin));
    }

    /**
     * 模板方法中需要替换的代码
     */
    abstract void code();
}
