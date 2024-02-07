package com.csoft.kata.designpatterns.facade;

import lombok.Getter;

@Getter
public class Computer {

    private final CPU cpu;
    private final Memory memory;
    private final HardDrive hardDrive;
    private boolean started;

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void start() {
        cpu.start();
        memory.load();
        hardDrive.read();
        this.started = true;
    }

}
