package com.sdp.problems.medium.nearestsmallernum;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackSolution {
    public static void main(String[] args) {
        solution(new int[]{1, 6, 7, 8, 9, 5, 4, 3, 2 });
    }

    static void solution(int[] a) {
        //https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
        //recommends using Deque implementation instead of Stack class
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0; i<a.length; i++) {
            if (i > 0)  System.out.print(", ");
            while (!stack.isEmpty() && stack.peek() >= a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                System.out.print("-1");
            } else {
                System.out.print(stack.peek());
            }
            stack.push(a[i]);
        }
    }
}
