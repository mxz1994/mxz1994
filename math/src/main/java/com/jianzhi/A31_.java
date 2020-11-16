package com.jianzhi;

import java.util.Stack;

/**
 *   栈的压入、弹出序列
 *
 *   输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 *
 * 例如序列 1,2,3,4,5 是某栈的压入顺序，序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列，但 4,3,5,1,2 就不可能是该压栈序列的弹出序列。
 *
 * @author mxz on 2020/11/12 17:20
 */
public class A31_ {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {4,3,5,1,2};
        boolean pop = isPop(a1, a2);
        System.out.println("pop = " + pop);
    }

    private static boolean isPop(int[] pushSequence, int[] popSequence) {
        int n = pushSequence.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushSequence[pushIndex]);
            // 1. 堆栈不为空  2.且对比的弹出队列没走完，3. 当
            while (!stack.isEmpty()
                    && popIndex < n
                    && stack.peek() == popSequence[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
