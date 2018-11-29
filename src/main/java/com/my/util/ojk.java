package com.my.util;

/**
 * @Author: dongqihang
 * @Date: Created in 19:19 2018/11/6
 */
public class ojk {
    public static int[] getNext(String ps) {

        char[] p = ps.toCharArray();

        int[] next = new int[p.length];

        next[0] = -1;

        int j = 0;

        int k = -1;

        while (j < p.length - 1) {

            if (k == -1 || p[j] == p[k]) {

                next[++j] = ++k;

            } else {

                k = next[k];

            }

        }

        return next;

    }

    public static void main(String[] args) {
        int[] ints=getNext("ABABAAB");
        for (int i :
                ints) {
            System.out.print(i+" ");
        }
    }
}
