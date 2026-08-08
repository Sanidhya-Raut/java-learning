package com.sanidhya.day04.model;

public class TicketCounter {
    private int availableTickets = 10;

    public synchronized void  getAvailableTickets(int tickets) {
        try {
            if (availableTickets > 0 && availableTickets >= tickets) {
                Thread.sleep(2000);
                availableTickets = availableTickets - tickets;
                System.out.println("Tickets Booked for : " + Thread.currentThread().getName());
            } else {
                System.out.println("required tickets not available For " + Thread.currentThread().getName());
            }

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());;
        }
        System.out.println("Tickets available after calculation = " + availableTickets);
    }

}
