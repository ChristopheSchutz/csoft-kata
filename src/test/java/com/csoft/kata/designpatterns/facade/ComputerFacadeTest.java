package com.csoft.kata.designpatterns.facade;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComputerFacadeTest {

    @Test
    public void should_start_computer() {
        var computerFacade = new Computer();
        computerFacade.start();
        
        Assertions.assertThat(computerFacade.isStarted()).isTrue();
        Assertions.assertThat(computerFacade.getCpu().isStarted()).isTrue();
        Assertions.assertThat(computerFacade.getMemory().isStarted()).isTrue();
        Assertions.assertThat(computerFacade.getHardDrive().isStarted()).isTrue();
    }
}
