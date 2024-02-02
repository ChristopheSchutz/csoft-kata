package com.csoft.kata.adventofcraft.day08;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordVerificationProgramTest {
    @Test
    void should_succeed() {
        PasswordVerificationProgram passwordVerificationProgram = new PasswordVerificationProgram("*1Abcdefgh");
        Assertions.assertThat(passwordVerificationProgram.verify()).isTrue();
    }

    @Test
    void should_contain_special_characters() {
        PasswordVerificationProgram passwordVerificationProgram = new PasswordVerificationProgram("1Abcdefgh");
        Assertions.assertThat(passwordVerificationProgram.verify()).isFalse();
    }

    @Test
    void should_fail_no_number() {
        PasswordVerificationProgram passwordVerificationProgram = new PasswordVerificationProgram("Abcdefgh");
        Assertions.assertThat(passwordVerificationProgram.verify()).isFalse();
    }

    @Test
    void should_fail_less_than_8_characters() {
        PasswordVerificationProgram passwordVerificationProgram = new PasswordVerificationProgram("abc");
        Assertions.assertThat(passwordVerificationProgram.verify()).isFalse();
    }

    @Test
    void should_fail_no_capital_letter() {
        PasswordVerificationProgram passwordVerificationProgram = new PasswordVerificationProgram("abcdefgh");
        Assertions.assertThat(passwordVerificationProgram.verify()).isFalse();
    }

    @Test
    void should_fail_no_lowercase_letter() {
        PasswordVerificationProgram passwordVerificationProgram = new PasswordVerificationProgram("ABCDEFGH");
        Assertions.assertThat(passwordVerificationProgram.verify()).isFalse();
    }
}
