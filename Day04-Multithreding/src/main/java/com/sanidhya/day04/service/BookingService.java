package com.sanidhya.day04.service;

import com.sanidhya.day04.model.TicketCounter;
import com.sanidhya.day04.task.BookingTask;

public class BookingService  {

    public void getTicket(int ticket1,int ticket2){

        TicketCounter ticketCounter = new TicketCounter();

        BookingTask bookingTask1 = new BookingTask(ticketCounter,ticket1);
        BookingTask bookingTask2 = new BookingTask(ticketCounter,ticket2);

        Thread thread1 = new Thread(bookingTask1);
        Thread thread2 = new Thread(bookingTask2);

        thread1.start();
        thread2.start();

    }
}