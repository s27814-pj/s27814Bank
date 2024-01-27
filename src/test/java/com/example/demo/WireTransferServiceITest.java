package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class WireTransferServiceITest {

    @MockBean
    private ClientStorage clientStorage;

    @Autowired
    private WireTransferService wireTransferService;

    @Test
    void shouldFindClientById(){
        Client client = new Client(10,"test",10);
        List<Client> clientList= new ArrayList<>();
        clientList.add(client);
        when(clientStorage.getClientStorageList()).thenReturn(clientList);

        assertThat(wireTransferService.findClientByID(10)).isEqualTo(client);
    }

    @Test
    void shouldNotFindClientById(){
        Client client = new Client(10,"test",10);
        List<Client> clientList= new ArrayList<>();
        clientList.add(client);
        when(clientStorage.getClientStorageList()).thenReturn(clientList);
        assertThrows(NoSuchElementException.class, () -> wireTransferService.findClientByID(0));
    }

    @Test
    void shouldNotLowerBelow0(){
        Client client = new Client(20, "testw",10);
        List<Client> clientList= new ArrayList<>();
        clientList.add(client);
        when(clientStorage.getClientStorageList()).thenReturn(clientList);

        assertThrows(RuntimeException.class, ()-> wireTransferService.makeWireTransfer(10,100));
    }

    @Test
    void shouldLowerAmount(){
        Client client = new Client(20, "testw",10);
        List<Client> clientList= new ArrayList<>();
        clientList.add(client);
        when(clientStorage.getClientStorageList()).thenReturn(clientList);
        WireTransferOut out =wireTransferService.makeWireTransfer(10,1);
        assertThat(out.getAmount()).isEqualTo(19.0);
    }

    @Test
    void shouldNotAddMoney(){
        Client client = new Client(20, "testw",10);
        List<Client> clientList= new ArrayList<>();
        clientList.add(client);
        when(clientStorage.getClientStorageList()).thenReturn(clientList);
        assertThrows(NoSuchElementException.class, () ->wireTransferService.addMoney(110,10));

    }

}