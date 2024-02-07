package com.csoft.kata.designpatterns.command;

public class VolumeDownCommand implements Command {
    private final AdjustableVolume adjustableVolume;

    public VolumeDownCommand(AdjustableVolume adjustableVolume) {
        this.adjustableVolume = adjustableVolume;
    }

    public void execute() {
        adjustableVolume.volumeDown();
    }
}
