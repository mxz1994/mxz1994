package com.jianzhi;

/**
 * 将一个字符串中的空格替换成 "%20"。
 *
 * Input:
 * "A B"
 *
 * Output:
 * "A%20B"
 *
 * 将空格替换成字符， 先扩充， 然后倒序添加符号， 也不需要copy
 * @author mxz on 2020/09/29 16:10
 */
public class A05 {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("A B");
        replaceSpace(str);
    }

    public static String replaceSpace(StringBuffer str) {
        int p1 = str.length() - 1; // 指向原始字符的位置
        for (int i = 0; i < p1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        // 最终字符串的长度
        int p2 = str.length() - 1; // 新的位置
        while (p1 >= 0 && p2 > p1) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--,'0');
                str.setCharAt(p2--,'2');
                str.setCharAt(p2--,'%');
            } else {
                str.setCharAt(p2--, c);
            }
        }
        return str.toString();
    }
}
