package com.zhuhao.design_mode.decorator.d;

/**
 * 业务场景：星巴克卖咖啡，一开始只有四种咖啡
 * decaf低咖啡因 Espresso浓缩咖啡 DarkRoast焦炒咖啡 HouseBlend首选咖啡
 * <p>
 * 因为咖啡有共性，所以开发人员把他们的共性提到一个父类中：beverage
 * <p>
 * 针对c包中的问题，使用“装饰器模式”来解救
 *
 * @Author halk
 * @Date 2020/11/6 11:33
 */
public abstract class Beverage { //bai ve ri ge 饮料

    private String description;

    /**
     * 花费的价格
     *
     * @return
     */
    public abstract double cost();

    public Beverage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
