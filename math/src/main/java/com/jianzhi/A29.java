package com.jianzhi;

import java.util.ArrayList;

/**
 * 按顺时针的方向，从外到里打印矩阵的值。
 * 下图的矩阵打印结果为：1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10
 *
 * 设置四个边界，打印
 * @author mxz on 2020/11/12 16:26
 */
public class A29 {
    static int[][] a = {{1,2,3},{4,5,6},{7,8,9}};

    public static void main(String[] args) {
        ArrayList<Integer> ret = new ArrayList<>();
        // 上下左右四个边界
        int w2 = a[0].length-1, w1 = 0;
        int h2 = a.length-1, h1 = 0;
        // 当四个边界没汇合往下继续执行
        while (w1 <= w2 && h1 <= h2) {
            // 上
            for (int i = w1; i < w2; i++) {
                ret.add(a[h1][i]);
            }
            // 右
            for (int i = h1; i < h2; i++) {
                ret.add(a[i][w2]);
            }
            // 下
            if (h1 != h2) {
                for (int i = h2; i > h1; i--) {
                    ret.add(a[h2][i]);
                }
            }
            // 左
            if (w1 != w2) {
                for (int i = w2; i > w1; i--) {
                    ret.add(a[i][w1]);
                }
            }

            // 一遍循环后全部缩小一个范围
            w1++; h1++; w2--; h2--;
        }
        System.out.println("ret = " + ret);
    }
}

