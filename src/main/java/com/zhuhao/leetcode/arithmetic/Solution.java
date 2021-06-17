package com.zhuhao.leetcode.arithmetic;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 示例：给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @Author halk
 * @Date 2020/12/28 15:18
 */
public class Solution {

    /**
     * 方案一，暴力枚举
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，
     * 然后将 x 插入到哈希表中，
     * 即可保证不会让 x 和自己匹配。
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashMap.containsKey(target - nums[i])) {
//                hashMap.forEach((x, y) -> System.out.println(x + "\t" + y));
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{1, 2, 3, 8, 99, 44, 55, 66}, 67);
        System.out.println(Arrays.toString(ints));

        int[] ints2 = twoSum2(new int[]{1, 2, 3, 8, 99, 44, 55, 66}, 67);
        System.out.println(Arrays.toString(ints2));
    }

}
