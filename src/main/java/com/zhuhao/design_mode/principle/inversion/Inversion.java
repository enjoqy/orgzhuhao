package com.zhuhao.design_mode.principle.inversion;

import org.junit.Test;

/**
 * 依赖倒转原则：需要依赖高层，不能依赖细节实现
 * - 底层模块尽量都要有抽象类和接口，或者两者都有，程序稳定性更好
 * - 变量的声明类型尽量是抽象类或接口，这样我们的变量引用和实际对象之间，就存在一个缓冲层，利于程序的扩展和优化
 * - 依赖传递的方式有三种
 * - - 接口传递：参数用接口声明，实际传递进来的是接口的实现类
 * - - 构造方法传递：在通过构造方法创建对象时将依赖传递进去
 * - - set方法传递：创建完对象使用set方法将对象设置进去
 *
 * @Author halk
 * @Date 2020/10/30 9:19
 */
public class Inversion {

    /**
     * 接口传递：参数用接口声明，实际传递进来的是接口的实现类
     */
    @Test
    public void test1() {
        ITVAndOpenClass itvAndOpenClass = new ITVAndOpenClass();
        itvAndOpenClass.play(new ChangHong());
    }

    /**
     * 构造方法传递：在通过构造方法创建对象时将依赖传递进去
     */
    @Test
    public void test02(){
        ITVAndOpenClass2 itvAndOpenClass2 = new ITVAndOpenClass2(new ChangHong2());
        itvAndOpenClass2.play();
    }

    /**
     * set方法传递：创建完对象使用set方法将对象设置进去
     */
    @Test
    public void test03(){
        ITVAndOpenClass3 itvAndOpenClass3 = new ITVAndOpenClass3();
        itvAndOpenClass3.setItv(new ChangHong3());
        itvAndOpenClass3.play();
    }

}

//接口传递：参数用接口声明，实际传递进来的是接口的实现类
interface ITV {
    void open();
}

interface ITVAndOpen {
    void play(ITV itv);
}

class ChangHong implements ITV {

    @Override
    public void open() {
        System.out.println("changhong1 open..");
    }
}

class ITVAndOpenClass implements ITVAndOpen {

    @Override
    public void play(ITV itv) {
        itv.open();
    }

}


//构造方法传递：在通过构造方法创建对象时将依赖传递进去
interface ITV2 {
    void open();
}

interface ITVAndOpen2 {
    void play();
}

class ChangHong2 implements ITV2 {

    @Override
    public void open() {
        System.out.println("changhong2 open..");
    }
}

class ITVAndOpenClass2 implements ITVAndOpen2 {

    private ITV2 itv;

    public ITVAndOpenClass2(ITV2 itv) {
        this.itv = itv;
    }

    @Override
    public void play() {
        this.itv.open();
    }

}

//set方法传递：创建完对象使用set方法将对象设置进去
interface ITV3 {
    void open();
}

interface ITVAndOpen3 {
    void play();
}

class ChangHong3 implements ITV3 {

    @Override
    public void open() {
        System.out.println("changhong3 open..");
    }
}

class ITVAndOpenClass3 implements ITVAndOpen3 {

    private ITV3 itv;

    public void setItv(ITV3 itv) {
        this.itv = itv;
    }

    public ITVAndOpenClass3() {
    }

    @Override
    public void play() {
        this.itv.open();
    }

}


