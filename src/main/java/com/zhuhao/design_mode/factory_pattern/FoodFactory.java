package com.zhuhao.design_mode.factory_pattern;

/**
 * @Author halk
 * @Date 2020/10/15 15:07
 */
public interface FoodFactory {

    /**
     * @Author halk
     * @Description 制作
     * @Date 2020/10/15 15:16
     * @Param [name]
     * @return com.zhuhao.design_mode.factory_pattern.Food
     **/
    Food makeFood(String name);
}
