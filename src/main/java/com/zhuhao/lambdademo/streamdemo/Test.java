package com.zhuhao.lambdademo.streamdemo;

import com.zhuhao.lambdademo.entity.Artist;
import com.zhuhao.lambdademo.entity.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 练习
 *
 * @author: zhuhao
 * @date: 2019/4/6 0006 10:48
 */
public class Test {

    /*
     * 1.给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
     * 		给定【1，2，3，4，5】，返回【1，4，9，16，25】
     */
    public static void test01() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> newList = list.stream().map(x -> x * x).collect(Collectors.toList());
        newList.forEach(System.out::println);
    }

    /*
     * 2.怎样用map和reduce方法数一数流中有多少个Employee呢？
     */
    public static void test02() {
        List<Employee> employees = Arrays.asList(
                new Employee(10010, "张三", 18, 9999.99),
                new Employee(10011, "李四", 13, 9),
                new Employee(10012, "王五", 14, 89),
                new Employee(10013, "袁六", 15, 900),
                new Employee(10014, "方七", 16, 977)
        );
        Optional<Integer> count1 = employees.stream().map(e -> 1).reduce(Integer::sum);
        System.out.println("count1 = " + count1.get());
    }

    /*
     * 3.连接字符串数组，逗号隔开，去掉首尾逗号
     */
    public static void test03() {
        String[] str = {"a", "b", "c", "d"};
        String str1 = Arrays.stream(str).collect(Collectors.joining("+"));
        System.out.println(str1);

        //在通过指定字符分割字符串
        String[] split = str1.split("\\+");
        Arrays.stream(split).forEach(System.out::println);
    }

    /*
     * 4.编写一个求和函数，计算流中所有数的和。例int addUp(Stream numbers)
     */
    public static int test04(Stream<Integer> numbers) {
        Optional<Integer> reduce = numbers.reduce(Integer::sum);
        return reduce.get();
    }

    /*
     * 5.编写一个函数，参数为艺术家集合，返回一个字符串集合，其中包含了艺术家的姓名与国籍。
     * (艺术家类名为Artist,里面有获得姓名与国籍的get方法getName()与getNationality())
     */
    public static Map<String, String> test05(List<Artist> artists) {
        Map<String, String> map = artists.stream().collect(Collectors.toMap(Artist::getName, Artist::getNationality));
        return map;
    }

    /*
     * 7.计算一个字符串小写字母的个数
     */
    public static long test07(String str) {

        long count = str.chars().filter(Character::isLowerCase).count();
        return count;
    }

    /*
     * 8.在一个字符串集合中，找出包含最多小写字母的字符串
     */
    public static String test08(List<String> strList) {
        Optional<String> max = strList.stream().max(
                (s1, s2) -> (int) (s1.chars().filter(Character::isLowerCase).count() - s2.chars().filter(Character::isLowerCase).count()));
        return max.get();
    }


    public static void main(String[] args) {
        String str = "Abcd";
        long l = test07(str);
        System.out.println(l);
    }
        /*List<Artist> artists = Arrays.asList(
                new Artist("11", 1, "aa", "japan"),
                new Artist("12", 1, "aa", "japan"),
                new Artist("13", 1, "aa", "japan"),
                new Artist("14", 1, "aa", "japan")

                );
        Map<String, String> map = test05(artists);
        System.out.println(map);*/
}
