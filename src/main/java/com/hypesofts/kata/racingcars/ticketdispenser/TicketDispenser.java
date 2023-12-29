package com.hypesofts.kata.racingcars.ticketdispenser;

public class TicketDispenser
{
    private TurnNumberSequence turnNumberSequence;
    public TicketDispenser(TurnNumberSequence turnNumberSequence)
    {
        this.turnNumberSequence = turnNumberSequence;
    }

    public TurnTicket getTurnTicket()
    {
        int newTurnNumber = turnNumberSequence.getNextTurnNumber();
        TurnTicket newTurnTicket = new TurnTicket(newTurnNumber);

        return newTurnTicket;
    }
}