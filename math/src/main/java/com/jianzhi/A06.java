package com.jianzhi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 从尾到头打印链表
 *
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 *
 * 尾递归， 或栈
 * @author mxz on 2020/09/29 16:29
 */
public class A06 {
    public static void main(String[] args) {
        ListNode first = new ListNode();
        ListNode pre = first;
        for (int i = 0; i < 10; i++) {
            ListNode listNode = new ListNode();
            pre.next = listNode;
            pre = listNode;
            pre.value = i;
        }
        ArrayList<Integer> integers = new ArrayList<>();
        revert(first.next, integers);
        System.out.println("integers = " + integers);
    }

    public static void revert(ListNode node, List list) {
        if (node != null) {
            revert(node.next, list);
            list.add(node.value);
        }
    }

    static class ListNode {
        public Integer value;
        public ListNode next;
    }
}



