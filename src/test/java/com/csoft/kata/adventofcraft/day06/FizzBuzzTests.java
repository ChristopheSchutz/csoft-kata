package com.csoft.kata.adventofcraft.day06;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FizzBuzzTests {

    @MethodSource
    public static Stream<Arguments> validInputs() {
        return Stream.of(
                Arguments.of(1, "1"),
                Arguments.of(67, "67"),
                Arguments.of(82, "82"),
                Arguments.of(3, "Fizz"),
                Arguments.of(66, "Fizz"),
                Arguments.of(99, "Fizz"),
                Arguments.of(5, "Buzz"),
                Arguments.of(50, "Buzz"),
                Arguments.of(85, "Buzz"),
                Arguments.of(15, "FizzBuzz"),
                Arguments.of(30, "FizzBuzz"),
                Arguments.of(45, "FizzBuzz")
        );
    }

    @MethodSource
    public static Stream<Arguments> invalidInputs() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(101),
                Arguments.of(-1)
        );
    }

    @ParameterizedTest
    @MethodSource("validInputs")
    void should_print_correct_result(Integer input, String result) throws OutOfRangeException {
        assertThat(FizzBuzz.convert(input))
                .isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("invalidInputs")
    void should_throw_exception_for_invalid_inputs(Integer input) {
        assertThatThrownBy(() -> FizzBuzz.convert(input))
                .isInstanceOf(OutOfRangeException.class);
    }
}