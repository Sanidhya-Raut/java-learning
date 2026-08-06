package com.sanidhya.day04;


import com.sanidhya.day04.service.BookingService;

public class Main {


    public static void main(String[] args) {

        BookingService bookService = new BookingService();
        bookService.getTicket(5,7);

    }


}
