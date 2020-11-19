package com.zhuhao.design_mode.factory_pattern;

/**
 * @Author halk
 * @Date 2020/10/15 15:12
 */
public class AmericanFoodFactory implements FoodFactory{
    @Override
    public Food makeFood(String name) {
        if (name.equals("A")){
            return new AmericanFoodA();
        }else if (name.equals("B")){
            return new AmericanFoodB();
        }else {
            return null;
        }
    }
}
