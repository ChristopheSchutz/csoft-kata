package com.csoft.kata.adventofcraft.day08;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class PasswordVerificationProgram {

    private final String input;

    public boolean verify() {
        return verifyLength() && verifyCapitalLetter() && verifyLowercaseLetter() && verifyNumber() && verifySpecialCharacters();
    }

    private boolean verifySpecialCharacters() {
        String[] characters = new String[]{".", "*", "#", "@", "$", "%", "&"};
        return Arrays.stream(characters).anyMatch(input::contains);
    }

    private boolean verifyNumber() {
        return input.matches(".*\\d.*");
    }

    private boolean verifyLowercaseLetter() {
        return !input.toUpperCase().equals(input);
    }

    private boolean verifyCapitalLetter() {
        return !input.toLowerCase().equals(input);
    }

    private boolean verifyLength() {
        return input.length() >= 8;
    }
}
