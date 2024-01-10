package com.csoft.kata.adventofcraft.day04;

import java.time.LocalDate;

public record Comment(String text, String author, LocalDate creationDate) {
}