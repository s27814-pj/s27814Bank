package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ClientStorage {



    private List<Client> clientStorageList = new ArrayList<>();

    public void addClient(Client client){
        clientStorageList.add(client);
    }

    public List<Client> getClientStorageList() {
        return clientStorageList;
    }

    public void purgeList(){
        clientStorageList.clear();
    }

}
