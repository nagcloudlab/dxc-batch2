package com.example;

import com.booking.BookingService;
import com.booking.BookingServiceImpl;
import com.payment.NEFTTransferServiceImpl;
import com.payment.TransferService;

public class Application {
    public static void main(String[] args) {

        // boot
        TransferService transferService = new NEFTTransferServiceImpl();
        BookingService bookingService = new BookingServiceImpl(transferService);

        // use
        bookingService.bookTicket();


    }
}
