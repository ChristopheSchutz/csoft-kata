package com.csoft.kata.designpatterns.command;

import lombok.Getter;

@Getter
public class TV implements Switchable, AdjustableVolume {

    private boolean on;
    private int volume;

    @Override
    public void switchOn() {
        this.on = true;
    }

    @Override
    public void switchOff() {
        this.on = false;
    }

    @Override
    public void volumeUp() {
        if (this.volume < 50) this.volume++;
    }

    @Override
    public void volumeDown() {
        if (this.volume > 0) this.volume--;
    }
}
