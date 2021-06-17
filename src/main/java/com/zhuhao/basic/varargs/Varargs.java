package com.zhuhao.basic.varargs;

import com.zhuhao.webcrawler.User;

import java.util.ArrayList;

/**
 * Varargs”是“variable number of arguments”的意思，可变参
 * <p>
 * 1.在方法中定义可变参数后，我们可以像操作数组一样操作该参数；
 * 2.如果该方法除了可变参数还有其它的参数，可变参数必须放到最后；
 * 3.调用使用了可变参数的方法时：
 * a. 可以不写参数，即传入空参；
 * b. 可以直接在里边写入参数，参数间用逗号隔开；
 * c. 可以传入一个数组；
 * 4.拥有可变参数的方法可以被重载，在被调用时，如果能匹配到参数定长的方法则优先调用参数定长的方法。
 * 5.可变参数可以兼容数组参数，但数组参数无法兼容可变参数。
 *
 * @author junhi
 * @date 2019/11/1 16:29
 */
public class Varargs {

    public int getMax(int... items) {
        int max = Integer.MIN_VALUE;
        //可变参不能像数组一样直接转为list，需要手动添加
        ArrayList<Integer> integers = new ArrayList<>();
        for (int item : items) {
            max = item > max ? item : max;
            integers.add(item);
        }
        integers.forEach(System.out::print);
        System.out.println();
        return max;
    }

    /**
     * 若除了可变长参数还有其它参数，可变长参数一定要放在最后
     *
     * @param number
     * @param items
     * @return
     */
    public int getMaxNumber(int number, int... items) {
        int sum = 0;
        for (int item : items) {
            if (item > number) {
                sum++;
            }
        }
        return sum;
    }

    public ArrayList<Integer> testUser(int number, User... users) {

        ArrayList<Integer> ints = new ArrayList<>();
        for (User user : users) {
            if (null != user.getSalary()) {
                int i = user.getSalary().compareTo(String.valueOf(number));
                ints.add(i);
            }
        }
        return ints;
    }

    public static void main(String[] args) {
        Varargs varargs = new Varargs();
        int[] a = {1, 2, 3, 4};
        int max = varargs.getMax(a);
        System.out.println(max);

        int maxNumber = varargs.getMaxNumber(2, 5, 5, 6, 0, 88);
        int maxNumber2 = varargs.getMaxNumber(2, a);
        System.out.println(maxNumber);
        System.out.println(maxNumber2);


        varargs.testUser(
                2,
                User.builder().salary("1").build(),
                User.builder().salary("2").build(),
                User.builder().salary("3").build(),
                User.builder().salary("12").build(),
                User.builder().salary("23").build(),
                User.builder().salary("234").build()
        ).forEach(x -> System.out.println(x));
    }

}
