package com.zhuhao.design_mode.principle.single_responsibilities;

/**
 *
 * 单一职责原则：
 * - 降低类的复杂度，一个类只负责一项职责
 * - 提高类的可读性，可维护性
 * - 降低变更引起的风险
 * - 通常我们需要遵守单一职责原则，只有当逻辑足够简单，才可以在代码级违反单一职责原则；只有类中的方法数量足够少，可以在方法级别保持单一职责原则
 * @Author halk
 * @Date 2020/10/29 14:57
 */
public class SingleResponsibility1 {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        //这种方式不符合单一职责原则，一个类应该只改一项事情
        vehicle.run("汽车");
        vehicle.run("飞机");
    }
}

class Vehicle {
    public void run(String vehicle){
        System.out.println(vehicle + "  在路上运行。。");
    }
}
