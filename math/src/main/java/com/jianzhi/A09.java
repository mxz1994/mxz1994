package com.jianzhi;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
 *
 * @author mxz on 2020/10/10 19:57
 */
public class A09 {
    public static void main(String[] args) throws Exception {
        Queue<String> queue = new Queue<>();
        queue.push("1");
        queue.push("2");
        queue.push("3");
        queue.push("4");
        for (int i = 0; i < 4; i++) {
            String pop = queue.pop();
            System.out.println("pop = " + pop);
        }
    }
}

class Queue<T> {
    Stack<T> pushstack = new Stack<>();
    Stack<T> popstack = new Stack<>();

    public void push(T s) {
        pushstack.push(s);

    }

    public T pop() throws Exception {
        if (popstack.isEmpty()) {
            while (!pushstack.isEmpty()) {
                popstack.push(pushstack.pop());
            }
        }
        if (popstack.isEmpty()) {
            throw new Exception("queue is empty");
        }
        return popstack.pop();
    }
}
