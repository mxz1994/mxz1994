package com.jianzhi;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 1. 使用两个最小顶堆队列， 左边放小的，右边放大的 奇数位的时候，放右边， 偶数位放左边， 先放右边
 * 2。
 * @author mxz on 2020/11/12 19:31
 */
public class A41_1 {
    public static void main(String[] args) {
         PriorityQueue<Integer> right = new PriorityQueue<>((a1, a2) -> a2 - a1);
        right.add(1);
        right.add(2);
        right.add(14);
        right.add(12);
        right.add(16);
        System.out.println("right = " + right);
        int size = right.size();
        for (int i = 0; i < size; i++) {
            System.out.println("right.poll() = " + right.poll());
        }

    }
    /* 大顶堆，存储左半边元素 */
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);  // 左边大顶堆 poll 弹出最大值
    /* 小顶堆，存储右半边元素，并且右半边元素都大于左半边 */
    private PriorityQueue<Integer> right = new PriorityQueue<>();   // 默认小顶堆，弹出最小值  // 为了取中间值， 插入时， 偶数位插入右边在弹到左边 。奇数位，放到左边吧左边最大值弹出
    /* 当前数据流读入的元素个数 */
    private int N = 0;

    public void Insert(Integer val) {
        /* 插入要保证两个堆存于平衡状态 */
        if (N % 2 == 0) {
            /* N 为偶数的情况下插入到右半边。
             * 因为右半边元素都要大于左半边，但是新插入的元素不一定比左半边元素来的大，
             * 因此需要先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆顶元素即为最大元素，此时插入右半边 */
            left.add(val);
            right.add(left.poll());
        } else {
            right.add(val);
            left.add(right.poll());
        }
        N++;
    }

    public Double GetMedian() {
        if (N % 2 == 0)
            return (left.peek() + right.peek()) / 2.0;
        else
            return (double) right.peek();
    }
}
