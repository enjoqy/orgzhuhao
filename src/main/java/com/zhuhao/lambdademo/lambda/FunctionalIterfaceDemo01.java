package com.zhuhao.lambdademo.lambda;

import com.zhuhao.lambdademo.entity.Student;
import com.zhuhao.lambdademo.entity.Teacher;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * 函数式接口：
 * 1.定义：有且只有一个抽象方法的接口。
 * 2.Java8内置的四大核心函数式接口
 * Consumer<T> ：消费型接口
 * void accept(T t);
 * <p>
 * Supplier<T> ：供给型接口
 * T get();
 * <p>
 * Function<T,R> ：函数型接口
 * R apply(T t);
 * <p>
 * Predicate<T> ：断言型接口
 * boolean jdbctest(T t);
 * <p>
 * Lambda表达式的基础语法
 * 1.Java8中引入了一个新的操作符 “->” （箭头操作符或Lambda操作符）
 * 2.左侧：Lambda表达式的参数列表（接口抽象方法的参数列表）
 * 右侧：Lambda表达式中所需执行的功能，即Lambda体（抽象方法的实现）
 * 3.Lambda需要函数式接口的支持
 * <p>
 * Lambda表达式的语法格式
 * 1.无参，无返回值  () -> System.out.println("Hello Lambda!");
 * 2.有一个参数，无返回值  (x) -> System.out.println(x) 只有一个参数，小括号可以省略不写
 * 3.有两个以上的参数，有返回值，Lambda体有多条语句  (x,y) -> {System.out.println("Hello Lambda!");return Integer.compare(x, y);};
 * 4.有两个以上的参数，有返回值，Lambda体只有一条语句，return 和 {} 都可以省略
 * 5.Lambda的参数列表的数据类型可以省略不写，因为JVM编译器可以根据上下文推断出数据类型（类型推断）
 * <p>
 * Lambda表达式需要“函数式接口”的支持
 * 函数式接口：接口中只有一个抽象方法（不包括和Object类中public修饰的方法同名的方法）时，称为函数式接口
 * 可以使用注解@FunctionalInterface修饰，判断是否为函数式接口
 *
 * @author junki
 * @date 2019年4月4日
 */

/**
 * 函数式接口
 *
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 */
public class FunctionalIterfaceDemo01 {

    public static void test1() {
        //自定义接口类
        Student student = (Student) new PersonFactory().apply("student");
        String name = student.getName();
        System.out.println(name);

        //接口的内部类实现
        Teacher teacher = (Teacher) new Function<String, Object>() {
            @Override
            public Object apply(String type) {
                switch (type) {
                    case "student":
                        return new Student("nijie");
                    case "teacher":
                        return new Teacher("方俊杰");
                    default:
                        return null;
                }
            }
        }.apply("teacher");
        System.out.println(teacher.getName());

        //lambda表达式内部实现类
        Function<String, Object> function = type -> {
            switch (type) {
                case "student":
                    return new Student("nijie");
                case "teacher":
                    return new Teacher("方俊杰");
                default:
                    return null;
            }
        };
        Student student1 = (Student) function.apply("student");
        System.out.println(student1);
    }

    public static void test02() {
        List<String> names = Arrays.asList("nijie", "zhengyong", "luoyueyang");
        names.forEach(name -> System.out.println(name));

        names.forEach(name -> {
            if (name.length() > 5) {
                System.out.println(name);
            }
        });

        int[] age = {1, 2, 3, 4, 5, 6};
        //TODO
        //不能用foreach
        for (int i = 0; i < age.length; i++) {
            System.out.print(i + "\t");
        }

    }

    public static void main(String[] args) {

        test02();


    }
}
