package com.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * 和为 S 的两个数字
 *
 * 在有序数组中找出两个数，使得和为给定的数 S。如果有多对数字的和等于 S，输出两个数的乘积最小的。
 *
 * 使用双指针，一个指针指向元素较小的值，一个指针指向元素较大的值。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
 *
 * 如果两个指针指向元素的和 sum == target，那么这两个元素即为所求。
 * 如果 sum > target，移动较大的元素，使 sum 变小一些；
 * 如果 sum < target，移动较小的元素，使 sum 变大一些。
 *
 * @author mxz on 2020/11/13 17:04
 */
public class A57_1 {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 7, 9};

    }

    public ArrayList<Integer> FindNumbersWithSum(int[] nums, int target) {
        // 双指针 头， 尾
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int cur = nums[i] + nums[j];
            if (cur == target)
                return new ArrayList<>(Arrays.asList(nums[i], nums[j]));
            if (cur < target) // 头右移
                i++;
            else
                j--;  // 尾左移
        }
        return new ArrayList<>();
    }
}
