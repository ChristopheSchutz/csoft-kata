package com.csoft.kata.adventofcraft.day12;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GreeterTest {

    @Test
    void saysHello() {
        var greeter = GreeterFactory.create();

        assertThat(greeter.greet())
                .isEqualTo("Hello.");
    }

    @Test
    void saysHelloFormally() {
        var greeter = GreeterFactory.create(GreeterFactory.FORMAL);

        assertThat(greeter.greet())
                .isEqualTo("Good evening, sir.");
    }

    @Test
    void saysHelloCasually() {
        var greeter = GreeterFactory.create(GreeterFactory.CASUAL);

        assertThat(greeter.greet())
                .isEqualTo("Sup bro?");
    }

    @Test
    void saysHelloIntimately() {
        var greeter = GreeterFactory.create(GreeterFactory.INTIMATE);

        assertThat(greeter.greet())
                .isEqualTo("Hello Darling!");
    }
}