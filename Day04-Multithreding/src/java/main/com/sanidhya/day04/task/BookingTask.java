package com.sanidhya.day04.task;

import com.sanidhya.day04.model.TicketCounter;

public class BookingTask implements Runnable{

    TicketCounter ticketCounter;
    int tickets;

    public BookingTask(TicketCounter ticketCounter, int tickets) {
        this.ticketCounter = ticketCounter;
        this.tickets = tickets;
    }

    @Override
    public  void  run() {
        ticketCounter.getAvailableTickets(tickets);
    }
}
