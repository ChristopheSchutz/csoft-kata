package com.csoft.kata.designpatterns.facade;

import lombok.Getter;

@Getter
public class HardDrive {

    boolean started;

    protected void read() {
        System.out.println("HardDrive is reading...");
        this.started = true;
    }
}
