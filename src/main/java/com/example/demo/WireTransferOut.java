package com.example.demo;

public class WireTransferOut {
    private Status wireTransferOutStatus;
    private double amount;

    public WireTransferOut(Status wireTransferOutStatus, double amount){
        this.amount=amount;
        this.wireTransferOutStatus=wireTransferOutStatus;
    }

    public Status getWireTransferOutStatus() {
        return wireTransferOutStatus;
    }

    public double getAmount() {
        return amount;
    }
}
