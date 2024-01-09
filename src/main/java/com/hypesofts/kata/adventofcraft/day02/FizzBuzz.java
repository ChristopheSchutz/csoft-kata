package com.hypesofts.kata.adventofcraft.day02;

public class FizzBuzz {
    private FizzBuzz() {
    }

    public static String convert(Integer input) throws OutOfRangeException {
        verifyInput(input);
        if (input % 3 == 0 && input % 5 == 0) {
            return "FizzBuzz";
        }
        if (input % 3 == 0) {
            return "Fizz";
        }
        if (input % 5 == 0) {
            return "Buzz";
        }
        return input.toString();
    }

    private static void verifyInput(Integer input) throws OutOfRangeException {
        if (input <= 0 || input > 100) {
            throw new OutOfRangeException();
        }
    }
}