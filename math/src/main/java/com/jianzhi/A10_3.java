package com.jianzhi;

import java.util.Arrays;

/**
 * 变态跳台阶
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 跳上 n-1 级台阶，可以从 n-2 级跳 1 级上去，也可以从 n-3 级跳 2 级上去...，那么
 * f(n-1) = f(n-2)+f(n-3)+ .... + f(0)
 * 同样，跳上 n 级台阶，可以从 n-1 级跳 1 级上去，也可以从 n-2 级跳 2 级上去... ，那么
 * f(n) = f(n-1) + f(n-2) + .... + f(0)
 * f(n) = 2*f(n-1)
 *
 * @author mxz on 2020/10/10 20:42
 */
public class A10_3 {

    public static void main(String[] args) {

    }

    // 笨方法，全部跳一遍
    public int JumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++)
            // 跳到 i 有几种方法 dp[i]
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];
        return dp[target - 1];
    }

    public int JumpFloorII2(int target) {
        return (int) Math.pow(2, target - 1);
    }
}
