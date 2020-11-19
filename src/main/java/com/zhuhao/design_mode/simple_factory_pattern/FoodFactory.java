package com.zhuhao.design_mode.simple_factory_pattern;

/**
 *
 * @Author halk
 * @Date 2020/10/15 14:50
 */
public class FoodFactory {

    public static Food makeFood(String name) {
        if (name.equals("兰州拉面")) {
            return new LanZhouNoodle();
        } else if (name.equals("黄焖鸡")) {
            return new HuangMenChicken();
        } else {
            return null;
        }
    }

}
