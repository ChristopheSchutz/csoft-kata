package com.csoft.kata.racingcars.ticketdispenser;

public class DefaultTurnNumberSequence implements TurnNumberSequence {

    private static int _turnNumber = 0;

    public int getNextTurnNumber() {
        return _turnNumber++;
    }

}