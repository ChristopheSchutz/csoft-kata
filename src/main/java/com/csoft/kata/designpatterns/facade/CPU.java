package com.csoft.kata.designpatterns.facade;

import lombok.Getter;

@Getter
public class CPU {

    boolean started;

    protected void start() {
        System.out.println("CPU is starting...");
        this.started = true;
    }
}
