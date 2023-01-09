package com.booking;

import com.exception.AccountBalanceException;
import com.exception.AccountNotFoundException;
import com.payment.TransferService;

/**
 * team-1
 */


public class BookingServiceImpl implements BookingService {

    private TransferService transferService;

    public BookingServiceImpl(TransferService transferService) {
        this.transferService = transferService;
    }

    public void bookTicket() {

        String source = "131";
        String destination = "311";
        double amount = 500.00;

        try {
            transferService.transfer(amount, source, destination);
            System.out.println("ticket confirmed");
        } catch (AccountNotFoundException e) {
            System.out.println("Ex-" + e.getMessage());
        } catch (AccountBalanceException e) {
            System.out.println("Ex-" + e.getMessage());
        }


    }

}
