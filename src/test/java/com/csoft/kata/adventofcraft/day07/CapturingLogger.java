package com.csoft.kata.adventofcraft.day07;

import com.csoft.kata.adventofcraft.day07.dependencies.Logger;

import java.util.ArrayList;
import java.util.List;

public class CapturingLogger implements Logger {
    private final List<String> lines = new ArrayList<>();

    @Override
    public void info(String message) {
        lines.add("INFO: " + message);
    }

    @Override
    public void error(String message) {
        lines.add("ERROR: " + message);
    }

    public List<String> getLoggedLines() {
        return lines;
    }
}