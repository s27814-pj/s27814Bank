package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

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
        Client client = new Client(10,"test");
        List<Client> clientList= new ArrayList<>();
        clientList.add(client);
        when(clientStorage.getClientStorageList()).thenReturn(clientList);

        assertThat(wireTransferService.findClientByID(0)).isEqualTo(client);
    }

}