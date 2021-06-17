package com.zhuhao.design_mode.prototype;

import org.junit.Test;
import org.openjdk.jol.vm.VM;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 原型模式
 * <p>
 * 需要被克隆的类实现Cloneable接口，并重写clone方法
 * <p>
 * VM.current().addressOf()是openJDK下jol工具包用来获取内存地址
 *
 * @Author halk
 * @Date 2020/11/3 15:25
 */
public class PrototypeTest {

    /**
     * 原始方法
     */
    @Test
    public void test01() {
        Sheep sheep = new Sheep("duoli", 10, "china");

        //通过创建实例进行赋值的方式创建，这个是原始方法
        ArrayList<Sheep> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Sheep sheepClone = new Sheep(sheep.getName(), sheep.getAge(), sheep.getAddress());
            list.add(sheepClone);
        }

        list.forEach(x -> {
            System.out.println(x);
            //判断属性内容是否一样
            System.out.println(x.equals(sheep));
            //判断内存地址是否一样
            System.out.println(x == sheep);

            /**
             * VM.current().addressOf()是openJDK下jol工具包用来获取内存地址
             */

            System.out.println("x内存地址: " + VM.current().addressOf(x));
            System.out.println("sheep内存地址: " + VM.current().addressOf(sheep));
        });
    }

    /**
     * 实现Cloneable,调用clone方法，此为浅拷贝
     *
     * @throws CloneNotSupportedException
     */
    @Test
    public void test02() throws CloneNotSupportedException {
        Sheep sheep = new Sheep("duoli", 10, "china");

        ArrayList<Sheep> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            Sheep sheepClone = (Sheep) sheep.clone();
            list.add(sheepClone);
        }

        list.forEach(x -> {
            System.out.println(x);
            //判断属性内容是否一样
            System.out.println(x.equals(sheep));
            //判断内存地址是否一样
            System.out.println(x == sheep);

            System.out.println("x内存地址: \t" + VM.current().addressOf(x));
            System.out.println("sheep内存地址: \t" + VM.current().addressOf(sheep));
        });
    }

    /**
     * 深拷贝，实现方式1：通过重写clone方法
     * @throws CloneNotSupportedException
     */
    @Test
    public void test03() throws CloneNotSupportedException {

        User user = new User(
                "lanlan",
                24,
                1,
                new Sheep("duoli", 2, "helan"),
                Arrays.asList(new Sheep("duoli2", 1, "japan")));

        User user2 = (User)user.clone();

        System.out.println(user);
        System.out.println(user2);

        //判断引用地址以及内容是否相同
        System.out.println(user == user2);
        System.out.println(user.equals(user2));

        //使用第三方工具直接打印出内存地址
        System.out.println(VM.current().addressOf(user.getSheep()));
        System.out.println(VM.current().addressOf(user2.getSheep()));
        //使用==判断内存地址是否相同也是可以的
        System.out.println(user.getSheep() == user2.getSheep());

        System.out.println(VM.current().addressOf(user.getSheepList()));
        System.out.println(VM.current().addressOf(user2.getSheepList()));
        System.out.println(user.getSheepList() == user2.getSheepList());

        System.out.println(VM.current().addressOf(user.getSheepList().get(0)));
        System.out.println(VM.current().addressOf(user2.getSheepList().get(0)));
    }

    /**
     * 深拷贝方式二：通过流对象进行拷贝，推荐使用
     */
    @Test
    public void test04(){
        User user = new User(
                "lanlan",
                24,
                1,
                new Sheep("duoli", 2, "helan"),
                Arrays.asList(new Sheep("duoli2", 1, "japan")));

        User user2 = (User)user.deepClone();

        //判断引用地址以及内容是否相同
        System.out.println(user == user2);
        System.out.println(user.equals(user2));

        //使用第三方工具直接打印出内存地址
        System.out.println(VM.current().addressOf(user.getSheep()));
        System.out.println(VM.current().addressOf(user2.getSheep()));
        //使用==判断内存地址是否相同也是可以的
        System.out.println(user.getSheep() == user2.getSheep());

        System.out.println(VM.current().addressOf(user.getSheepList()));
        System.out.println(VM.current().addressOf(user2.getSheepList()));
        System.out.println(user.getSheepList() == user2.getSheepList());

        System.out.println(VM.current().addressOf(user.getSheepList().get(0)));
        System.out.println(VM.current().addressOf(user2.getSheepList().get(0)));
    }
}

