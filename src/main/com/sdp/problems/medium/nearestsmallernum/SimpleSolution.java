package com.sdp.problems.medium.nearestsmallernum;
public class SimpleSolution {
    public static void main(String[] args) {
        solution(new int[]{1, 5, 0, 3, 4, 5});
    }

    static void solution(int[] a) {
        for (int i=0; i<a.length; i++) {
            if (i > 0)  System.out.print(", ");
            boolean found = false;
            for (int j = i-1; j >=0; j--) {
                if (a[j] < a[i]) {
                    System.out.print(a[j]);
                    found = true;
                    break;
                }
            }
            if (!found) System.out.print("-1");
        }
    }
}
