package com.csoft.kata.designpatterns.command;

import lombok.Getter;

@Getter
public class Light implements Switchable {

    private boolean on;

    @Override
    public void switchOn() {
        this.on = true;
    }

    @Override
    public void switchOff() {
        this.on = false;
    }
}
