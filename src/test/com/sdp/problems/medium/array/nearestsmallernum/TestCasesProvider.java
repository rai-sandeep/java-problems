package com.sdp.problems.medium.array.nearestsmallernum;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

class TestCasesProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 6, 2 },
                        new int[]{-1, 1, 1 }),
                Arguments.of(
                        new int[]{1, 5, 0, 3, 4, 5},
                        new int[]{-1, 1, -1, 0, 3, 4}),
                Arguments.of(
                        new int[]{1, 6, 7, 8, 9, 5, 4, 3, 2},
                        new int[]{-1, 1, 6, 7, 8, 1, 1, 1, 1})
        );
    }
}