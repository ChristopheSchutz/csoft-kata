package com.hypesofts.kata.passwordvalidator;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PasswordValidator {
    public ValidationResult validate(String input) {
        Collection<String> errors = computeErrors(input);
        return ValidationResult.build(errors);
    }

    private Collection<String> computeErrors(String input) {
        Collection<String> errors = new ArrayList<>();
        if (isTooShort(input)) {
            errors.add("The password must be at least 8 characters");
        }
        if (isMissingNumbers(input)) {
            errors.add("The password must contain at least 2 numbers");
        }
        if (isMissingCapitalLetter(input)) {
            errors.add("The password must contain at least one capital letter");
        }
        if (isMissingSpecialCharacter(input)) {
            errors.add("The password must contain at least one special character");
        }
        return errors;
    }

    private boolean isTooShort(String input) {
        return input.length() < 8;
    }

    private boolean isMissingNumbers(String input) {
        return input.matches("^(?=(\\D*\\d){0,1}\\D*$).+$");
    }

    private boolean isMissingCapitalLetter(String input) {
        return !input.matches(".*[A-Z].*");
    }

    private boolean isMissingSpecialCharacter(String input) {
        return !input.matches(".*[!#$%&].*");
    }

    @AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
    public static class ValidationResult {

        public static ValidationResult build(Collection<String> errors) {
            if (errors.isEmpty()) {
                return valid();
            } else {
                return invalid(errors);
            }
        }
        private static ValidationResult valid() {
            return new ValidationResult(true, null);
        }

        private static ValidationResult invalid(Collection<String> errors) {
            return new ValidationResult(false, errors);
        }

        @Getter
        private boolean valid;
        private Collection<String> errors;

        public String getErrors() {
            return String.join("\n", errors);
        }
    }
}
