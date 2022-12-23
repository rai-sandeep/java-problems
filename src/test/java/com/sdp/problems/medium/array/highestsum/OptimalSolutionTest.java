package com.sdp.problems.medium.array.highestsum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OptimalSolutionTest {

    @ParameterizedTest
    @ArgumentsSource(TestCasesProvider.class)
    void solution(int[] input, int expected) {
        System.out.println("Input:    "+ Arrays.toString(input));
        System.out.println("Expected: "+ expected);

        int output = OptimalSolution.solution(input);

        System.out.println("Output:   "+ output);
        System.out.println();

        assertEquals(expected, output);
    }
}