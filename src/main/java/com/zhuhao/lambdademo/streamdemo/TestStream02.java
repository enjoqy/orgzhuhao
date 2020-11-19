package com.zhuhao.lambdademo.streamdemo;

import com.zhuhao.lambdademo.entity.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * * 中间操作
 *
 * @author: zhuhao
 * @date: 2019/4/6 0006 22:14
 */
public class TestStream02 {
    static List<Employee> employees = Arrays.asList(
            new Employee(10010, "张三", 18, 9999.99),
            new Employee(10011, "李四", 13, 9),
            new Employee(10012, "王五", 14, 89),
            new Employee(10013, "袁六", 15, 900),
            new Employee(10014, "方七", 16, 977),
            new Employee(10014, "方七", 16, 977),
            new Employee(10014, "方七", 16, 977)
    );

    @Test
    public void test10(){
        employees.stream().distinct().filter(x -> x.getAge() >15 && x.getSalary() > 1000).forEach(System.out::println);
    }

    /*
     * 筛选与切片
     * filter--筛选，接收Lambda，从流中排除某些元素
     * limit(n)--截断流，使其元素不超过给定数量
     * skip(n)--跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个则返回空流，与limit(n)互补
     * distinct--去重，通过流所生成元素的hashCode()和equals()去掉重复元素
     */
    public static void test01() {
        //内部迭代：迭代操作由Stream API 完成
        //执行中间操作，实际不会执行任何操作
        Stream<Employee> stream = employees
                .stream()
                .filter((x) -> {
                    System.out.println("执行中间操作");
                    return x.getAge() > 15;
                });
        //执行终止操作是一次性全部处理，称为惰性求值
        stream.forEach(System.out::println);
    }

    public static void test02() {
        employees.stream()
                .filter((x) -> {
                    System.out.println("短路");
                    //短路：不需要迭代所有，获取两个结果之后停止迭代
                    return x.getSalary() > 500;
                })
                .limit(2)
                .forEach(System.out::println);
    }

    public static void test03() {
        employees.stream()
                .filter((x) -> x.getId() > 10011)
                .skip(2)  //跳过前两个，取后面的
                .forEach(System.out::println);
    }

    public static void test04() {
        employees.stream()
                .filter((x) -> x.getSalary() > 10)
                .skip(3)
                .distinct()  //去重失败
                //TODO
                .forEach(System.out::println);
    }

    public static void test07() {
        employees.stream()
                .distinct() //TODO
                .collect(Collectors.toList())
                .forEach(System.out::println);  //去重失败
    }

    public static void test05() {
        List<String> list = Arrays.asList("1", "1", "2", "3", "1");
        String str = list.stream().distinct().collect(Collectors.joining(","));
        System.out.println(str);
    }

    public static void test06() {
        List<String> list = Arrays.asList(new String("1"), new String("1"), new String("2"), new String("3"));
        String str = list.stream().distinct().collect(Collectors.joining(","));
        System.out.println(str);
    }

    /*
     * 映射
     * map--接收Lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每一个元素上，并将其映射成一个新的元素
     * flatMap--接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     */
    public static void test08() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
        list.stream()
                .map((x) -> x.substring(0, 1).toUpperCase())
                .forEach(System.out::println);

        //流中有流，遍历的时候需要嵌套
        list.stream()
                .map(TestStream02::filterCharacter)  //返回Stream<Stream<Chararcter>>
                .forEach((q) -> q.forEach(System.out::println));

        System.out.println("------------------");
        //使用flatMap()解决此问题
        list.stream()
                .flatMap(TestStream02::filterCharacter)  //返回Stream<Chararcter>
                .forEach(System.out::println);
        //类比add(Collection coll)和addAll(Collection coll)方法
        //将集合作为元素添加到另一个集合，将集合中的元素添加到另一个集合
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    /*
     * 排序
     * sorted()--自然排序（Comparable）
     * sorted(Comparator com)--定制排序（Comparator）
     */
    public static void test09() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "aaa", "aba");
        list.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("-------------");
        employees.stream()
                .sorted((s1, s2) -> {
                    if (s1.getAge() == s2.getAge()) {
                        return s1.getName().compareTo(s2.getName());
                    } else {
                        return s1.getAge() - s2.getAge();
                    }
                })
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        test09();
    }
}
