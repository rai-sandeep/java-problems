package com.sdp.problems.medium.array.highestsum;
public class OptimalSolution {

    
    static int solution(int[] nums) {
        int largestSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum = Math.max(sum+num, num);
            if (sum > largestSum) largestSum = sum;
        }

        return largestSum;

    }
}
