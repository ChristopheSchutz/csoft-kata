package com.csoft.kata.passwordvalidator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    @Test
    public void should_not_be_valid_if_lower_than_8_characters() {
        PasswordValidator passwordValidator = new PasswordValidator();
        PasswordValidator.ValidationResult result = passwordValidator.validate("1234!Aa");
        Assertions.assertThat(result.isValid()).isFalse();
        Assertions.assertThat(result.getErrors()).isEqualTo("The password must be at least 8 characters");
    }

    @Test
    public void should_not_be_valid_if_less_than_2_numbers() {
        PasswordValidator passwordValidator = new PasswordValidator();
        PasswordValidator.ValidationResult result = passwordValidator.validate("abcdefghiJ!");
        Assertions.assertThat(result.isValid()).isFalse();
        Assertions.assertThat(result.getErrors()).isEqualTo("The password must contain at least 2 numbers");
    }

    @Test
    public void should_have_multiple_error_messages() {
        PasswordValidator passwordValidator = new PasswordValidator();
        PasswordValidator.ValidationResult result = passwordValidator.validate("abcD!");
        Assertions.assertThat(result.isValid()).isFalse();
        Assertions.assertThat(result.getErrors()).isEqualTo("The password must be at least 8 characters\nThe password must contain at least 2 numbers");
    }

    @Test
    public void should_not_be_valid_if_no_capital_letter() {
        PasswordValidator passwordValidator = new PasswordValidator();
        PasswordValidator.ValidationResult result = passwordValidator.validate("abcdefg01!");
        Assertions.assertThat(result.isValid()).isFalse();
        Assertions.assertThat(result.getErrors()).isEqualTo("The password must contain at least one capital letter");
    }

    @Test
    public void should_not_be_valid_if_no_special_character() {
        PasswordValidator passwordValidator = new PasswordValidator();
        PasswordValidator.ValidationResult result = passwordValidator.validate("ABCcdefg01");
        Assertions.assertThat(result.isValid()).isFalse();
        Assertions.assertThat(result.getErrors()).isEqualTo("The password must contain at least one special character");

    }
}
