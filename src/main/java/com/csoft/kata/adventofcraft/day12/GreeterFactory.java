package com.csoft.kata.adventofcraft.day12;

public class GreeterFactory {

    public static final String FORMAL = "formal";
    public static final String CASUAL = "casual";
    public static final String INTIMATE = "intimate";

    static Greeter create() {
        return new Greeter.DefaultGreeter();
    }

    static Greeter create(String formality) {
        return switch (formality) {
            case FORMAL -> new Greeter.FormalGreeter();
            case CASUAL -> new Greeter.CasualGreeter();
            case INTIMATE -> new Greeter.IntimateGreeter();
            default -> new Greeter.DefaultGreeter();
        };
    }
}
