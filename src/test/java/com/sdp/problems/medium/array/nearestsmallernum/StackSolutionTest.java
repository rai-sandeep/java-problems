package com.sdp.problems.medium.array.nearestsmallernum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class StackSolutionTest {

    @ParameterizedTest
    @ArgumentsSource(TestCasesProvider.class)
    void solution(int[] input, int[] expected) {
        System.out.println("Input:    "+ Arrays.toString(input));
        System.out.println("Expected: "+ Arrays.toString(expected));

        int[] output = StackSolution.solution(input);

        System.out.println("Output:   "+ Arrays.toString(output));
        System.out.println();

        assertArrayEquals(expected, output);
    }
}