package com.jianzhi;

/**
 * 斐波那契数列
 *  求斐波那契数列的第 n 项，n <= 39。
 *  f(n) = 0 (n =0); =1 (n = 1); f(n-1) + f(n-2) (n>1)
 * @author mxz on 2020/10/10 20:05
 */
public class A10 {
    public static void main(String[] args) {
        int n = 30;
        fibonacci1(n);
    }

    // 动态规划会把子问题的解缓存起来，从而避免重复求解子问题。
    private static int fibonacci1(int n) {
        if (n <= 1)
            return n;
        int[] fib = new int[n + 1];
        fib[1] = 1;
        for (int i = 2; i <= n; i++)
            fib[i] = fib[i - 1] + fib[i - 2];
        return fib[n];
    }

    private static int fibonacci2(int n) {
        if (n <= 1)
            return n;
        int pre2 = 0, pre1 = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = pre2 + pre1;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }
}
