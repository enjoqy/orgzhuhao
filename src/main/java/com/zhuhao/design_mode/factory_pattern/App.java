package com.zhuhao.design_mode.factory_pattern;


import java.util.Calendar;
import java.util.TimeZone;

/**
 *
 * 工厂模式
 *
 * 虽然都是调用 makeFood("A") 制作 A 类食物，但是，不同的工厂生产出来的完全不一样。
 *
 * 第一步，我们需要选取合适的工厂，然后第二步基本上和简单工厂一样。
 *
 * 核心在于，我们需要在第一步选好我们需要的工厂。比如，我们有 LogFactory 接口，实现类有 FileLogFactory 和 KafkaLogFactory，
 * 分别对应将日志写入文件和写入 Kafka 中，显然，我们客户端第一步就需要决定到底要实例化 FileLogFactory 还是 KafkaLogFactory，
 * 这将决定之后的所有的操作。
 *
 *
 *
 * @Author halk
 * @Date 2020/10/15 15:15
 */
public class App {
    public static void main(String[] args) {
//        FoodFactory factory = new ChineseFoodFactory();
        FoodFactory factory = new AmericanFoodFactory();
        Food food = factory.makeFood("A");
        System.out.println(food.getName());

        //jdk这里使用了简单工厂模式
        Calendar instance = Calendar.getInstance(TimeZone.getDefault());

    }
}
