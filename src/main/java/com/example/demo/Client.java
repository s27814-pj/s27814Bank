package com.example.demo;

public class Client {

    private int id;
    private static int idCounter=0;
    private double amount;
    private String otherData;

    public Client(double amount, String otherData){
        this.id=idCounter++;
        this.amount=amount;
        this.otherData=otherData;
    }

    public Client(double amount, String otherData, int id){
        this.id=id;
        this.amount=amount;
        this.otherData=otherData;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getClientData(){
        return this.id + "z Saldem:" + this.amount + " Inne dane klienta: " +otherData;
    }
}
