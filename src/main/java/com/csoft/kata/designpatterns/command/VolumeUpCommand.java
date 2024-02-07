package com.csoft.kata.designpatterns.command;

public class VolumeUpCommand implements Command {
    private final AdjustableVolume adjustableVolume;

    public VolumeUpCommand(AdjustableVolume adjustableVolume) {
        this.adjustableVolume = adjustableVolume;
    }

    public void execute() {
        adjustableVolume.volumeUp();
    }
}
