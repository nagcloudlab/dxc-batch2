package org.example.dto;

import lombok.Data;

@Data
public class TransferRequest {

    private double amount;
    private String source;
    private String destination;

}
