package com.zhuhao.lambdademo.lambda;
/**
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 */


import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

/**
 * 方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用“方法引用”
 * 			（可以理解为方法引用是Lambda表达式的另外一种表现形式）
 *
 * 语法格式：
 * 		1.对象::实例方法名
 * 		2.类::静态方法名
 * 		3.类::实例方法名
 *
 * 注意事项：
 * 		1.Lambda体中调用方法的参数列表及返回值类型，要与函数式接口中抽象方法的函数列表及返回值类型保持一致
 * 		2.Lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用 类::实例方法名
 *
 * --------------------------------------------------------------------------------------
 * 构造器引用：
 *
 * 语法格式：类名::new
 *
 * 注意事项：需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表一致
 * ------------------------------------------------------------------------------------
 * 数组引用：
 *
 * 语法格式：数据类型[]::new;
 *
 * @author junki
 * @date 2019年4月4日
 */
public class MethodReferencesDemo02 {


    public void test03() {
        //方法的引用
        List<String> names = Arrays.asList("1", "2", "3");
        names.forEach(System.out::println);

        BiPredicate<String, String> bp = (x, y) -> x.compareTo(y) > 0 ? true : false;
        boolean nihao = bp.test("nihao", "1");
        System.out.println(nihao);
    }

    public static void main(String[] args) {

    }
}
