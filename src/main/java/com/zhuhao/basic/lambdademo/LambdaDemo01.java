package com.zhuhao.basic.lambdademo;

import com.zhuhao.basic.lambdademo.entity.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 */
public class LambdaDemo01 {

    private static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {

        List<String> list = Arrays.asList("111", "22", "3");

        //TODO
        list.stream().filter(name -> name.length() == 2).forEach(System.out::println);

        list.forEach(System.out::println);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }).start();

        new Thread(() -> System.out.println("hello")).start();


        LambdaDemo01 demo = new LambdaDemo01();
        employeeList.add(new Employee(1, "a", 2, 10.0));
        employeeList.add(new Employee(1, "a", 2, 11.0));
        employeeList.add(new Employee(1, "a", 2, 12.0));
        employeeList.add(new Employee(1, "a", 2, 13.0));

        demo.getEmployeeByPredicate(a -> a.getSalary() == 10.0).forEach(System.out::println);


    }

    public List<Employee> getEmployeeByPredicate(Predicate<Employee> predicate){
//        ArrayList<Employee> employees = new ArrayList<>();
//        for (Employee employee : employeeList) {
//            if (predicate.test(employee)){
//                employees.add(employee);
//            }
//        }
//        return employees;
        return employeeList.stream().filter(predicate).collect(Collectors.toList());
    }

    @FunctionalInterface
    public interface MyInterface {
        void sayHello(String name, String content);
    }

    @Test
    public void test03(){

        employeeList.add(new Employee(1, "a", 2, 10.0));
        employeeList.add(new Employee(1, "a", 2, 11.0));
        employeeList.add(new Employee(1, "a", 4, 12.0));
        employeeList.add(new Employee(1, "a", 5, 13.0));

        long count = employeeList.stream().filter(a -> a.getAge() == 2).count();
        System.out.println(count);

        List<Employee> collect = employeeList.stream()
                .filter(a -> a.getAge() >= 18)
                .filter(a -> a.getSalary() >= 1000.0)
                .sorted((o1, o2) -> o2.getAge() - o1.getAge() )
                .collect(Collectors.toList());

        collect.forEach(x -> System.out.println(x));
    }

    @Test
    public void test02(){
        MyInterface i = (n, c) -> System.out.println(n + c);
        i.sayHello("hello", "world");
    }

    @Test
    public void test01(){
        Function<String, String> f = t -> t;
        System.out.println(f.apply("aaa"));
    }

    @Test
    public void test001(){
        employeeList.add(new Employee(1, "a", 2, 10.0));
        employeeList.add(new Employee(2, "a", 2, 11.0));
        employeeList.add(new Employee(2, "a", 2, 12.0));
        employeeList.add(new Employee(1, "a", 2, 13.0));

        List<Integer> list = employeeList.stream()
                .map(employee -> employee.getId())
                .distinct()
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }

}
