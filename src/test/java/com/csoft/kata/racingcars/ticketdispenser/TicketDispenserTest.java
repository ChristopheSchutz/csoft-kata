package com.csoft.kata.racingcars.ticketdispenser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TicketDispenserTest {

    @Test
    void should_return_first_ticket_with_value_0() {
        TicketDispenser dispenser = new TicketDispenser(new MockTurnSequence());
        TurnTicket ticket = dispenser.getTurnTicket();
        assertEquals(0, ticket.getTurnNumber());
    }

    @Test
    void should_return_two_tickets_with_incremented_value() {
        TicketDispenser dispenser = new TicketDispenser(new MockTurnSequence());
        assertEquals(0, dispenser.getTurnTicket().getTurnNumber());
        assertEquals(1, dispenser.getTurnTicket().getTurnNumber());
    }

    @Test
    void should_return_two_tickets_from_different_dispensers_with_incremented_value() {
        TurnNumberSequence sequence = new MockTurnSequence();
        TicketDispenser dispenser = new TicketDispenser(sequence);
        TicketDispenser dispenser2 = new TicketDispenser(sequence);
        assertEquals(0, dispenser.getTurnTicket().getTurnNumber());
        assertEquals(1, dispenser2.getTurnTicket().getTurnNumber());
    }

    static class MockTurnSequence implements TurnNumberSequence {

        private int turnNumber = 0;

        public int getNextTurnNumber() {
            return turnNumber++;
        }
    }


}