package com.csoft.kata.designpatterns.stepbuilder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

public class ProductBuilderTest {

    @Test
    public void should_have_properties_set() {
        var productMandatory = ProductBuilder.newBuilder()
                .name("Keyboard")
                .price(BigDecimal.TEN)
                .build();

        Assertions.assertThat(productMandatory.getName()).isEqualTo("Keyboard");
        Assertions.assertThat(productMandatory.getPrice()).isEqualTo(BigDecimal.TEN);
        Assertions.assertThat(productMandatory.getDescription()).isEqualTo(Optional.empty());
        Assertions.assertThat(productMandatory.getCategory()).isEqualTo(Optional.empty());
        Assertions.assertThat(productMandatory.getUuid()).isNotNull();

        var productWithDescription = ProductBuilder.newBuilder()
                .name("Keyboard")
                .price(BigDecimal.TEN)
                .description("Mechanical LED Keyboard")
                .build();

        Assertions.assertThat(productWithDescription.getName()).isEqualTo("Keyboard");
        Assertions.assertThat(productWithDescription.getPrice()).isEqualTo(BigDecimal.TEN);
        Assertions.assertThat(productWithDescription.getDescription()).isEqualTo(Optional.of("Mechanical LED Keyboard"));
        Assertions.assertThat(productWithDescription.getCategory()).isEqualTo(Optional.empty());
        Assertions.assertThat(productWithDescription.getUuid()).isNotNull();

        var productComplete = ProductBuilder.newBuilder()
                .name("Keyboard")
                .price(BigDecimal.TEN)
                .description("Mechanical LED Keyboard")
                .category("External devices")
                .build();

        Assertions.assertThat(productComplete.getName()).isEqualTo("Keyboard");
        Assertions.assertThat(productComplete.getPrice()).isEqualTo(BigDecimal.TEN);
        Assertions.assertThat(productComplete.getDescription()).isEqualTo(Optional.of("Mechanical LED Keyboard"));
        Assertions.assertThat(productComplete.getCategory()).isEqualTo(Optional.of("External devices"));
        Assertions.assertThat(productComplete.getUuid()).isNotNull();
    }
}
