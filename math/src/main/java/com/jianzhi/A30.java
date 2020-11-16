package com.jianzhi;

import java.util.Stack;

/**
 *
 * 包含 min 函数的栈
 *
 * 实现一个包含 min() 函数的栈，该方法返回当前栈中最小的值。
 *
 *  使用两个栈 一个保存数据，一个保存最小数据
 *  每次push的时候，判断是否大于内部最小值，大于的话，此时放最小值，这样保证pop后最小值仍然正确
 *  或者pop的时候进行判断
 *
 * @author mxz on 2020/11/12 17:08
 */
public class A30 {
    public static void main(String[] args) {
        A30 a30 = new A30();
        a30.push(4);
        a30.push(3);
        a30.push(1);
        a30.push(5);
    }

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        // peek 返回栈顶数据并不弹出
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
