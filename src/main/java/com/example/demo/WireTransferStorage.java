package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WireTransferStorage {

    private List<WireTransfer> wireTransferList = new ArrayList<>();

    public void addWireTransfer(WireTransfer wireTransfer){
        wireTransferList.add(wireTransfer);
    }

}
