package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class WireTransferService {
private final WireTransferStorage wireTransferStorage;
private final ClientStorage clientStorage;

public WireTransferService(WireTransferStorage wireTransferStorage, ClientStorage clientStorage){
    this.wireTransferStorage=wireTransferStorage;
    this.clientStorage=clientStorage;
}

public WireTransferOut makeWireTransfer(int idClient, double amount){

    WireTransfer wire = new WireTransfer(idClient, amount);
    Client client=null;

    client = findClientByID(idClient);
    //if (pleaseFindClientById(idClient).isEmpty())


    if (client!=null){
         if(!validateAmount(client, amount)) throw new RuntimeException("za male saldo");

        //if(!validateAmount(client, amount)) return new WireTransferOut(Status.DECLINED_BY_CASH, client.getAmount());

        client.setAmount(client.getAmount()-amount);
        wire.setTransferStatus(Status.ACCEPTED);
    }
    else {
        wire.setTransferStatus(Status.DECLINED);

    }
    wireTransferStorage.addWireTransfer(wire);
    return new WireTransferOut(wire.getTransferStatus(), client.getAmount());
}

    public Client findClientByID(int id){
    Client client = null;
        for (Client k : clientStorage.getClientStorageList()) {
            if (k.getId() == id) {
                client = k;
                break;
            }
        }
            if (client ==null){
                throw new NoSuchElementException("Brak zarestrowanego klienta z id " + id);
            }
            else return client;
    }

//    public Optional<Client> pleaseFindClientById(int id){
//    return clientStorage.getClientStorageList().stream()
//            .filter(id -> Integer.valueOf(id.getId()).equals(id))
//            .findFirst();
//    }

    public WireTransferOut addMoney(int idClient, int amount){
    Client client = findClientByID(idClient);
        if (client!=null) {
            client.setAmount(client.getAmount() + amount);
        };
        return new WireTransferOut(Status.ACCEPTED,client.getAmount());
    }
    public String getClientData(int id){
    Client client = findClientByID(id);
    return client.getClientData();
    }

    public boolean validateAmount(Client client, double amount){
        return client.getAmount() >= amount;
    }
}
