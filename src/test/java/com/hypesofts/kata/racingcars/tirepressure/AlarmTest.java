package com.hypesofts.kata.racingcars.tirepressure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class AlarmTest {

    @ParameterizedTest
    @MethodSource("sensors")
    public void should_alarm_be_on_when_low_or_high_pressure(Sensor sensor, boolean shouldBeOn) {
        Alarm alarm = new Alarm(sensor);
        assertFalse(alarm.isAlarmOn());
        alarm.check();
        assertEquals(alarm.isAlarmOn(), shouldBeOn);
    }

    static Stream<Arguments> sensors() {
        return Stream.of(
                Arguments.of(new LowPressureSensor(), true),
                Arguments.of(new HighPressureSensor(), true),
                Arguments.of(new GoodPressureSensor(), false));
    }

    private static class LowPressureSensor implements Sensor {
        @Override
        public double popNextPressurePsiValue() {
            return 16;
        }
    }

    private static class HighPressureSensor implements Sensor {
        @Override
        public double popNextPressurePsiValue() {
            return 23;
        }
    }

    private static class GoodPressureSensor implements Sensor {
        @Override
        public double popNextPressurePsiValue() {
            return 19;
        }
    }

}