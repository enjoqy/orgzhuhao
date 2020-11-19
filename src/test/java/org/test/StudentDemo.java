package org.test;

public class StudentDemo {
    //成员变量
    private String name;
    private int age;
    private String weight;
    private String hight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHight() {
        return hight;
    }

    public void setHight(String hight) {
        this.hight = hight;
    }

    public void show() {
        System.out.println(name + age + weight + hight);
    }


    public static void main(String[] args) {
        StudentDemo studentDemo = new StudentDemo();
        studentDemo.setName("何文祥");
        studentDemo.setAge(18);
        studentDemo.setHight("200");


        studentDemo.show();
    }
}
