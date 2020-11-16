package com.jianzhi;

import java.util.ArrayList;

/**
 * 和为 S 的连续正数序列
 *
 * 输出所有和为 S 的连续正数序列。例如和为 100 的连续序列有：
 *
 * [9, 10, 11, 12, 13, 14, 15, 16]
 * [18, 19, 20, 21, 22]。
 *
 * @author mxz on 2020/11/13 17:29
 */
public class A57_2 {
    public static void main(String[] args) {

    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int start = 1, end = 2;
        int curSum = 3;
        while (end < sum) {
            // 当和大于输入
            if (curSum > sum) {
                curSum -= start;
                start++;
            } else if (curSum < sum) {
                end++;
                curSum += end;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++)
                    list.add(i);
                ret.add(list);
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }
        return ret;
    }
}
