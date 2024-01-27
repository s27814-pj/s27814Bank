package com.example.demo;

public enum Status {
    ACCEPTED("ok"), DECLINED("nie ok"), DECLINED_BY_CASH("za male srodki na koncie"), DECLINED_BY_CLIENT("id klient nie istnieje");

    private String description;

    public String getDescription() {
        return description;
    }
    Status (String description){
        this.description=description;
    }
}
