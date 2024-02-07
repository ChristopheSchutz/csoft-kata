package com.csoft.kata.designpatterns.command;

public class TurnOnCommand implements Command {
    private final Switchable switchable;

    public TurnOnCommand(Switchable switchable) {
        this.switchable = switchable;
    }

    public void execute() {
        switchable.switchOn();
    }
}
