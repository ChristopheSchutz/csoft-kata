package com.csoft.kata.adventofcraft.day12;

public interface Greeter {

    String greet();

    class DefaultGreeter implements Greeter {
        @Override
        public String greet() {
            return "Hello.";
        }
    }

    class FormalGreeter implements Greeter {
        @Override
        public String greet() {
            return "Good evening, sir.";
        }
    }

    class CasualGreeter implements Greeter {
        @Override
        public String greet() {
            return "Sup bro?";
        }
    }

    class IntimateGreeter implements Greeter {
        @Override
        public String greet() {
            return "Hello Darling!";
        }
    }
}