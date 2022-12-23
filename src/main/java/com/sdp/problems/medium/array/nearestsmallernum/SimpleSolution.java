package com.sdp.problems.medium.array.nearestsmallernum;
public class SimpleSolution {

    static int[] solution(int[] a) {
        int[] b = new int[a.length];
        for (int i=0; i<a.length; i++) {
            boolean found = false;
            for (int j = i-1; j >=0; j--) {
                if (a[j] < a[i]) {
                    b[i]=a[j];
                    found = true;
                    break;
                }
            }
            if (!found) b[i]=-1;
        }
        return b;
    }
}
