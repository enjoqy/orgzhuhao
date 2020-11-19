package com.zhuhao.lambdademo.lambda;

/**
 * @Author halk
 * @Date 2020/11/6 9:20
 */
public class StaticDemo {

    static Demo play(Demo demo){
        demo.b = 22;

        return demo;
    }


    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.setB(20);

        System.out.println(demo);

        play(demo);

        System.out.println(demo);
    }
}
