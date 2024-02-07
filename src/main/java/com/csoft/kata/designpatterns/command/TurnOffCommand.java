package com.csoft.kata.designpatterns.command;

public class TurnOffCommand implements Command {
    private final Switchable switchable;

    public TurnOffCommand(Switchable switchable) {
        this.switchable = switchable;
    }

    public void execute() {
        switchable.switchOff();
    }
}
