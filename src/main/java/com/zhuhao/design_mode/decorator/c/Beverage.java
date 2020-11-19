package com.zhuhao.design_mode.decorator.c;

import org.apache.xpath.operations.Bool;

/**
 * 业务场景：星巴克卖咖啡，一开始只有四种咖啡
 * decaf低咖啡因 Espresso浓缩咖啡 DarkRoast焦炒咖啡 HouseBlend首选咖啡
 * <p>
 * 因为咖啡有共性，所以开发人员把他们的共性提到一个父类中：beverage
 * <p>
 * 针对b包中的问题，我们不必为每一种咖啡加每一种调料都创建一个类，这样太麻烦
 * 我们可以在beverage类中添加四个属性，分别对应了加的四种调料
 *
 * @Author halk
 * @Date 2020/11/6 11:33
 */
public abstract class Beverage { //bai ve ri ge 饮料

    private String description;

    /**
     * soy 大豆
     * mocha 摩卡
     * bubble 泡沫
     */
    private boolean milk, soy, mocha, bubble;

    public Boolean getMilk() {
        return milk;
    }

    public void setMilk(Boolean milk) {
        this.milk = milk;
    }

    public Boolean getSoy() {
        return soy;
    }

    public void setSoy(Boolean soy) {
        this.soy = soy;
    }

    public Boolean getMocha() {
        return mocha;
    }

    public void setMocha(Boolean mocha) {
        this.mocha = mocha;
    }

    public Boolean getBubble() {
        return bubble;
    }

    public void setBubble(Boolean bubble) {
        this.bubble = bubble;
    }

    /**
     * 花费的价格
     *
     * @return
     */
    public double cost(){

        Double total = 0D;
        if (milk){
            total += 0.1;
        }
        if (soy){
            total += 0.2;
        }
        if (mocha){
            total += 0.3;
        }
        if (bubble){
            total += 0.4;
        }
        return total;
    }

    public Beverage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
