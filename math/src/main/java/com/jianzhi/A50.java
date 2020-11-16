package com.jianzhi;

import java.util.BitSet;

/**
 * 第一个只出现一次的字符位置
 *
 * 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。字符串只包含 ASCII 码字符。
 *
 * Input: abacc
 * Output: b
 *
 * 使用HashMap 或者其他 两个位操作只有一个为true
 *
 * @author mxz on 2020/11/12 16:49
 */
public class A50 {

    public static void main(String[] args) {
        String str = "abacc";
        int site = 0;
        BitSet bs1 = new BitSet(128);
        BitSet bs2 = new BitSet(128);
        for (char c : str.toCharArray()) {
            if (!bs1.get(c)) {
                bs1.set(c);
            } else if (bs1.get(c) && bs2.get(c)) {
                bs2.set(c);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (bs1.get(c) && !bs2.get(c)) {
                // 0 1
                site = i; break;
            }
        }
        System.out.println("bs2 = " + bs2);
    }
}
