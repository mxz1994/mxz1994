package com.jianzhi;

/**
 *  跳台阶
 *
 *  一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 *  当 n = 1 时，只有一种跳法
 *
 *  当 n = 2 时，有两种跳法
 *
 *  跳 n 阶台阶，可以先跳 1 阶台阶，再跳 n-1 阶台阶；或者先跳 2 阶台阶，再跳 n-2 阶台阶
 *  f(n) = f(n-1) + f(n-2)
 * @author mxz on 2020/10/10 20:37
 */
public class A10_2 {
    public static void main(String[] args) {
        int n = 4;
        RectCover(n);
    }

    public static int RectCover(int target) {
        if (target <= 2){
            return target;
        }
        int pre1 = 2;
        int pre2 = 1;
        int result = 0;
        for (int i = 3; i <= target; i++){
            result = pre1 + pre2;
            pre2 = pre1;
            pre1 = result;
        }
        return pre1;
    }
}
