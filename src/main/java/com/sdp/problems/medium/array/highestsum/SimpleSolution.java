package com.sdp.problems.medium.array.highestsum;
public class SimpleSolution {


    static int solution(int[] nums) {
        int largestSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j >= 0; j--) {
                currentSum += nums[j];
                if (currentSum > largestSum) largestSum = currentSum;
            }
        }

        return largestSum;

    }
}
