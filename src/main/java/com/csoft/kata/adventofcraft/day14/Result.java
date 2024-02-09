package com.csoft.kata.adventofcraft.day14;

import lombok.Getter;

import java.util.List;
import java.util.Optional;

@Getter
public class Result<T> {

    private Optional<T> value;
    private List<String> errors;


    private Result(T value, List<String> errors) {
        this.value = Optional.ofNullable(value);
        this.errors = errors;
    }

    public static final <T> Result<T> success(T value) {
        return new Result<>(value, null);
    }

    public static final Result failure(List<String> errors) {
        return new Result(null, errors);
    }

    public static final Result failure(String error) {
        return new Result(null, List.of(error));
    }
}
