package com.csoft.kata.designpatterns.command;

public class Remote {

    public Remote() {
    }

    public void pressButton(Command command) {
        command.execute();
    }
}
