package com.payment;

public interface TransferService {
    void transfer(double amount, String source, String destination);
}
