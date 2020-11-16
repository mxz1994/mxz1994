package com.jianzhi;

import java.util.LinkedList;

/**
 * 字符流中第一个不重复的字符
 *
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
 *
 * 一个队列暂存字符， 一个数组存出现次数， 每次都判断， 将>1 的筛选出去， 弹出队列头部就是最早只出现一次的
 *
 * @author mxz on 2020/11/13 14:35
 */
public class A41_2 {
    public static void main(String[] args) {
        String s = "goole";
        A41_2 a41_2 = new A41_2();
        for (char c : s.toCharArray()) {
            a41_2.Insert(c);
        }
        System.out.println("a41_2 = " + a41_2.queue); // ocvgle
        System.out.println("a41_2 = " + a41_2.FirstAppearingOnce());
    }

    private int[] cnts = new int[128];
    private LinkedList<Character> queue = new LinkedList<>();

    public void Insert(char ch) {
        // 加入并计数
        cnts[ch]++;
        queue.add(ch);

        // 判断头是否重复，重复就弹出
        while (!queue.isEmpty() && cnts[queue.peek()] > 1)
            queue.poll();
    }

    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
