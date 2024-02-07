package com.csoft.kata.designpatterns.command;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoteTest {

    @Test
    public void testRemote() {
        Remote remote = new Remote();

        Light light = new Light();
        Command switchOnCommand = new TurnOnCommand(light);
        remote.pressButton(switchOnCommand);

        TV tv = new TV();
        Command volumeUpCommand = new VolumeUpCommand(tv);
        remote.pressButton(volumeUpCommand);

        Assertions.assertThat(light.isOn()).isTrue();
        Assertions.assertThat(tv.getVolume()).isEqualTo(1);
    }
}
