package com.zhuhao.basic.lambdademo.streamdemo;

import com.zhuhao.basic.lambdademo.entity.Employee;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 终止操作
 *
 * @author: zhuhao
 * @date: 2019/4/7 0007 12:29
 */
public class TestStream03 {
    static List<Employee> employees = Arrays.asList(
            new Employee(10010, "张三", 18, 9999.99),
            new Employee(10011, "李四", 33, 9),
            new Employee(10012, "王五", 44, 89),
            new Employee(10013, "袁六", 65, 900),
            new Employee(10014, "方七", 160, 977),
            new Employee(10014, "方七", 36, 977),
            new Employee(10014, "方七", 56, 977)
    );

    /*
     * 查找与匹配
     * allMatch--检查是否匹配所有元素
     * anyMatch--检查是否至少匹配一个元素
     * noneMatch--检查是否没有匹配元素
     * findFirst--返回第一个元素
     * findAny--返回当前流中的任意元素
     * count--返回流中元素的总个数
     * max--返回流中最大值
     * min--返回流中最小值
     */
    public static void test01() {
        boolean b1 = employees.stream()
                .allMatch((x) -> x.getName().equals("方七"));  //allMatch--检查是否匹配所有元素
        System.out.println(b1);

        boolean b2 = employees.stream()
                .anyMatch((x) -> x.getName().equals("方七"));  // anyMatch--检查是否至少匹配一个元素
        System.out.println(b2);

        boolean b3 = employees.stream()  //noneMatch--检查是否没有匹配元素
                .noneMatch((x) -> x.getName().equals("方七"));
        System.out.println(b3);

        //获取工资最高的员工
        Optional<Employee> findFirst = employees.stream()
                .sorted((s1, s2) -> -Double.compare(s1.getSalary(), s2.getSalary()))  //将元素拿出来自然排序，前面加“-”代表取反，倒序
                .findFirst();
        System.out.println(findFirst.get());

        //随便找出一个年龄大于13，小于18的员工
        Optional<Employee> any = employees.stream()
                .filter((x) -> (x.getAge() < 18) && (x.getAge() > 13))
                .findAny();
        System.out.println(any.get());
    }

    public static void test02() {
        //查看流中有多少元素
        long count = employees.stream().count();
        System.out.println(count);

        Optional<Employee> max = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(max.get());

        Optional<Double> min = employees.stream()
                .map(Employee::getSalary)
                .min(Double::compare);
        System.out.println(min.get());
    }

    /*
     * 归约
     * reduce(T identity,BinaryOperator)/reduce(BinaryOperator)--可以将流中的元素反复结合起来得到一个值
     * map-reduce模式，因Google用它进行网络搜索而出名
     */
    public static void test03() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        Optional<Double> reduce = employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(reduce.get());
    }

    /*
     * 收集
     * collect--将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
     */
    public static void test04() {
        //将名字取出来，单独放在在一个list集合中
        List<String> lsit = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        lsit.forEach(System.out::println);

        //将名字取出来，单独放在在一个set集合中，可以去重
        System.out.println("-------------------");
        Set<String> collect1 = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        collect1.forEach(System.out::println);

        //将salsry取出来，单独放在在一个set集合中，可以去重
        System.out.println("-------------------");
        Set<Double> collect = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.toSet());
        collect.forEach(System.out::println);

        System.out.println("-------------------");
        HashSet<String> collect2 = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        collect2.forEach(System.out::println);
    }

    public static void test05() {
        //总数
        Long collect = employees.stream().collect(Collectors.counting());
        System.out.println(collect);

        //平均值
        Double collect1 = employees.stream().collect(Collectors.averagingDouble(Employee::getAge));
        System.out.println(collect1);

        //平均值
        Double collect3 = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(collect3);

        //总结
        DoubleSummaryStatistics collect2 = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect2);

        //最大值
        Optional<Employee> max = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(max.get().getSalary());

        //最小值
        Optional<Employee> min = employees.stream().min(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(min.get().getSalary());
    }

    public static void test06() {
        //分组
        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getName));
        System.out.println(collect);

        //多级分组
        Map<Integer, Map<String, List<Employee>>> collect1 = employees.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.groupingBy((x) -> {
            if (x.getAge() <= 35) {
                return "青年";
            } else if (x.getAge() <= 50) {
                return "中年";
            } else {
                return "老年";
            }
        })));
        System.out.println(collect1);
    }

    public static void test07() {
        //分区
        Map<Boolean, List<Employee>> collect = employees.stream().collect(Collectors.partitioningBy((x) -> x.getSalary() >= 8000));
        System.out.println(collect);
    }

    public static void test08() {
        //简易统计
        DoubleSummaryStatistics collect = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect.getMax());
        System.out.println(collect.getAverage());
        System.out.println(collect.getCount());
        System.out.println(collect.getMin());
        System.out.println(collect.getSum());
        System.out.println(collect);
    }

    public static void test09() {
        String collect = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",", "\"", "\""));
        System.out.println(collect);
    }

    public static void main(String[] args) {
        test09();
    }

}
