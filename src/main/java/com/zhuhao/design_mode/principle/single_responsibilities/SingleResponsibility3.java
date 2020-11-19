package com.zhuhao.design_mode.principle.single_responsibilities;

/**
 *
 * 单一职责原则：
 * - 降低类的复杂度，一个类只负责一项职责
 * - 提高类的可读性，可维护性
 * - 降低变更引起的风险
 * - 通常我们需要遵守单一职责原则，只有当逻辑足够简单，才可以在代码级违反单一职责原则；只有类中的方法数量足够少，
 *      可以在方法级别保持单一职责原则
 * @Author halk
 * @Date 2020/10/29 14:57
 */
public class SingleResponsibility3 {

    public static void main(String[] args) {
        Vehicle2 vehicle2 = new Vehicle2();
        //这种在类级不符合单一职责原则，方法级别时是符合的，在当逻辑比较简单时可以这么干
        vehicle2.runByRoad("汽车");
        vehicle2.runByAir("飞机");
    }
}

class Vehicle2 {
    public void runByAir(String vehicle){
        System.out.println(vehicle + "  在天上飞。。");
    }
    public void runByRoad(String vehicle){
        System.out.println(vehicle + "  在路上跑。。");
    }
}
