package com.sanidhya.day04.model;

public class TicketCounter {
    private int availableTickets = 10;

    public synchronized int  getAvailableTickets(int tickets) {
        System.out.println("tickets available = "+ availableTickets);
        try{
            if(availableTickets>0 && availableTickets >= tickets){
                Thread.sleep(2000);
                availableTickets = availableTickets - tickets;
            }else{
                System.out.println("required tickets not available");
            }

        }catch (IllegalThreadStateException | InterruptedException e ){
            e.printStackTrace();
        }
        System.out.println("ticktes available after calculation = "+ availableTickets);
        return tickets;
    }


}
