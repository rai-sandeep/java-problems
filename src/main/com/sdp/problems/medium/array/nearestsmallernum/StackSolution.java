package com.sdp.problems.medium.array.nearestsmallernum;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackSolution {

    static int[] solution(int[] a) {
        int[] b = new int[a.length];
        //https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
        //recommends using Deque implementation instead of Stack class
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0; i<a.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= a[i]) {
                stack.pop();
            }
            b[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(a[i]);
        }
        return b;
    }
}
