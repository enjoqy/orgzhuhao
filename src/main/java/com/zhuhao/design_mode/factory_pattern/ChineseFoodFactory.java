package com.zhuhao.design_mode.factory_pattern;

/**
 * @Author halk
 * @Date 2020/10/15 15:09
 */
public class ChineseFoodFactory implements FoodFactory {
    @Override
    public Food makeFood(String name) {
        if (name.equals("A")){
            return new ChineseFoodA();
        }else if (name.equals("B")){
            return new ChineseFoodB();
        }else {
            return null;
        }
    }
}
