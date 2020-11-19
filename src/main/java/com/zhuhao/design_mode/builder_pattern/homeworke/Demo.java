package com.zhuhao.design_mode.builder_pattern.homeworke;

import org.junit.Test;

/**
 * 建造者模式练习：
 * <p>
 * 1.绘制游戏角色：
 * a。绘制脸型：瓜子脸、长饼脸、国字脸
 * b。绘制眼睛：大、小、圆
 * c。绘制体格：壮硕、瘦小、苗条
 * <p>
 * 有多种类型的角色可以绘制：男神、女神、型男、屌丝。。。
 * <p>
 * 写完以后，看看是否满足以下需求：
 * a。客户端不需要知道角色的绘制过程；
 * b。不同的角色绘制过程是否一样？是否进行了封装
 * c。后期扩充角色类型时是否能满足开闭原则？
 *
 * @Author halk
 * @Date 2020/11/5 15:34
 */
public class Demo {

    @Test
    public void test01(){
        //指挥者
        PersonDirect direct = new PersonDirect();

        //创建男神
        MaleGodBuilder maleGodBuilder = new MaleGodBuilder();
        Person maleGodPerson = direct.build(maleGodBuilder);
        System.out.println(maleGodPerson);

        //创建女神
        GoddessBuilder goddessBuilder = new GoddessBuilder();
        Person goddessPerson = direct.build(goddessBuilder);
        System.out.println(goddessPerson);

        //后期进行扩充时并不会影响之前的代码，（增加小丑）
        ClownBuilder clownBuilder = new ClownBuilder();
        Person clownPerson = direct.build(clownBuilder);
        System.out.println(clownPerson);

    }

}
