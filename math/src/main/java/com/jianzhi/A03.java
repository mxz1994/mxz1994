package com.jianzhi;

/**
 *
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *
 * Input:
 * {2, 3, 1, 0, 2, 5}
 *
 * Output:
 * 2
 *
 *  解题技巧：将值为i的数设置到第i位上， 判断 时间复杂度O(N)  O(1)
 * @author mxz on 2020/09/28 16:38
 */
public class A03 {
    public static void main(String[] args) {
        A03 a03 = new A03();
        int[] s = {2,3,1,0,2,5};
        int[] du = new int[s.length];
        boolean duplicate = a03.duplicate(s, du.length, du);
        System.out.println("duplicate = " + duplicate);
    }
    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0)
            return false;
        for (int i = 0; i < length; i++) {
            // 跳出循环条件 nums[i] == i 时 或者 数相等
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}