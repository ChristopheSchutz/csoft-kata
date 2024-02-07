package com.csoft.kata.designpatterns.facade;

import lombok.Getter;

@Getter
public class Memory {

    boolean started;

    protected void load() {
        System.out.println("Memory is loading...");
        this.started = true;
    }
}
