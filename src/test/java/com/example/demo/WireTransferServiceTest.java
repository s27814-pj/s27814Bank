package com.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WireTransferServiceTest {

    private ClientStorage clientStorage;
    private WireTransferService wireTransferService;

    private WireTransferStorage wireTransferStorage;

    @BeforeEach
    void setUp(){
        clientStorage = new ClientStorage();
        wireTransferStorage= new WireTransferStorage();
        wireTransferService = new WireTransferService(wireTransferStorage,clientStorage);
    }

    @AfterEach
    void tearDown(){
    clientStorage.purgeList();
    }

    @Test
    void shouldFindClientById(){
        Client client = new Client(25,"dom",10);
        clientStorage.addClient(client);

        assertThat(wireTransferService.findClientByID(10)).isEqualTo(client);
    }
    @Test
    void shouldNotFindClientById(){
        assertThrows(NoSuchElementException.class, () -> wireTransferService.findClientByID(0));
    }

    @Test
    void shouldLowerAmount(){
        Client client = new Client(25,"dom",10);
        clientStorage.addClient(client);
        wireTransferService.makeWireTransfer(10,5);

        assertThat(client.getAmount()).isEqualTo(20.0);
    }
    @Test
    void shouldBeSuccessStatus(){
        Client client = new Client(25,"dom",10);
        clientStorage.addClient(client);
        WireTransferOut out = wireTransferService.makeWireTransfer(10,5);
        assertThat(out.getWireTransferOutStatus()).isEqualTo(Status.ACCEPTED);
    }
}