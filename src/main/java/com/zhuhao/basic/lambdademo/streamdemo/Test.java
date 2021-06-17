package com.zhuhao.basic.lambdademo.streamdemo;

import com.zhuhao.basic.lambdademo.entity.Artist;
import com.zhuhao.basic.lambdademo.entity.Employee;
import org.apache.commons.lang.text.StrBuilder;

import java.util.*;
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
    @org.junit.Test
    public void test02() {
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
    @org.junit.Test
    public void test03() {
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

    /**
     * @return void
     * @Author halk
     * @Description 对集合中对象的某一个属性做单独处理
     * @Date 2020/3/20 14:02
     * @Param []
     **/
    @org.junit.Test
    public void test11() {
        List<Employee> employees = Arrays.asList(
                new Employee(10010, "张三", 18, 9999.99),
                new Employee(10011, "李四", 13, 9),
                new Employee(10012, "王五", 14, 89),
                new Employee(10013, "袁六", 15, 900),
                new Employee(10014, "方七", 16, 977)
        );
        List<Integer> collect = employees.stream().map(x -> x.getAge()).collect(Collectors.toList());

        collect.forEach(x -> System.out.println(x));
    }

    @org.junit.Test
    public void test12() {
        List<Employee> list = Arrays.asList(
                new Employee(10010, "张三", 18, 9999.99),
                new Employee(10011, "李四", 13, 9),
                new Employee(10012, "王五", 14, 89),
                new Employee(10013, "袁六", 15, 900),
                new Employee(10014, "方七", 16, 977)
        );
        for (Employee employee : list) {
            employee.setAge(1);
        }

        list.forEach(x -> System.out.println(x));
    }

    @org.junit.Test
    public void test13() {

        String str = "ab";

        int i = str.lastIndexOf(",");
        System.out.println(i);

        if (str.lastIndexOf(",") != -1 && str.substring(str.lastIndexOf(",")).equals(",")){
            System.out.println("shide");
            System.out.println(str.substring(0, str.lastIndexOf(",")));
        }else {
            System.out.println(str);
        }

        int a = 2;

        System.out.println("2".equals(String.valueOf(a)));

        StrBuilder builder = new StrBuilder("hello");
        builder.append("1");
        builder.insert(0, "0");
        System.out.println(builder);

        ArrayList<Map<String, String>> list = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        map.put("1", "11");
        map.put("2", "22");

        list.add(map);

        Map<String, String> map2 = new HashMap<>();
        map2.put("1", "11");
        map2.put("2", "22");

        list.add(map2);

        List<String> collect = list.stream().map(x -> x.get("1")).collect(Collectors.toList());
        System.out.println(collect.toString());

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
