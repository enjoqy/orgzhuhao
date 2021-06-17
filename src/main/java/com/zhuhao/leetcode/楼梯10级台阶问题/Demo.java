package com.zhuhao.leetcode.楼梯10级台阶问题;

import java.util.HashMap;
import java.util.Map;

/**
 * 有一座高度是10级台阶的楼梯，从下往上走，每跨一步只能向上1级或者2级台阶。要求用程序来求出一共有多少种走法。
 *
 * @Author halk
 * @Date 2021/3/6 14:47
 */
public class Demo {

    public static void main(String[] args) {
        int result = getClimbingWays(5);
        System.out.println(result);

        int result2 = getClimbingWays2(new HashMap<>(), 5);
        System.out.println(result2);
    }

    /**
     * 递归算法实现
     * 上述问题假设只差一步走到第10级，则F(10)=F(9)+F(8)，F(9)=F(8)+F(7)...F(3)=F(2)+F(1)（最优子结构）
     * F(1)：当只有一节楼梯时走法为1种，F(2)：当只有两节楼梯时走法为2种
     * <p>
     * 分析可知：算法时间复杂度过高，达到了O(2^n)，观察递归可知，出现了很多重复的f(*)，可将f(*)放入map中，用时取出即可。
     *
     * @param n
     * @return
     */
    private static int getClimbingWays(int n) {
        //当只有0或者负数节楼梯时走法为0种
        if (n <= 0) {
            return 0;
        }
        //当只有一节楼梯时走法为1种
        if (n == 1) {
            return 1;
        }
        //当只有两节楼梯时走法为2种
        if (n == 2) {
            return 2;
        }
        return getClimbingWays(n - 1) + getClimbingWays(n - 2);
    }

    /**
     * 备忘录算法
     * 对于递归算法来讲，F(*)重复计算的过多，可以将第一遇到的F(*)放入map中，下次在遇到直接取值即可
     *
     * @param map
     * @param n
     * @return
     */
    private static int getClimbingWays2(Map<Integer, Integer> map, int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int value = getClimbingWays2(map, n - 1) + getClimbingWays2(map, n - 2);
            map.put(n, value);
            return value;
        }
    }

    /**
     * 动态规划算法
     * 上述均为自顶向下计算，换种思路，自底向上计算，不使用递归。只需记住上次和上上次的走法数即可。
     * 台阶数：1  2  3  4  5  6  。。。。。
     * 走法数：1  2  3  5  8  13 。。。。。
     * 找规律，即可求解
     * <p>
     * 其时间复杂度为O(n)，空间复杂度为O(1)。
     * 上述问题只有一个变化维度，较简单。
     *
     * @param n
     * @return
     */
    private static int getClimbingWays3(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 3; i < n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }
}
