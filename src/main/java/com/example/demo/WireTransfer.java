package com.example.demo;

public class WireTransfer {

    private int idClient;
    private double valueToTransfer;
    private Status transferStatus;

    public WireTransfer(int idClient, double valueToTransfer){
        this.idClient=idClient;
        this.valueToTransfer=valueToTransfer;
    }

    public Status getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(Status transferStatus) {
        this.transferStatus = transferStatus;
    }
}
