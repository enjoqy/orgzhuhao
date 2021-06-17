package com.zhuhao.basic.lambdademo.entity;

public class Artist {
    private String name;
    private int age;
    private String adress;
    private String nationality;

    public Artist(String name, int age, String adress, String nationality) {
        this.name = name;
        this.age = age;
        this.adress = adress;
        this.nationality = nationality;
    }

    public Artist() {
    }

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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", adress='" + adress + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
