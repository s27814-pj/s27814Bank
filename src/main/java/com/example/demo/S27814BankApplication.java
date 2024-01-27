package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S27814BankApplication {

	private final ClientStorage clientStorage;
	private final WireTransferService wireTransferService;
	private final WireTransferStorage wireTransferStorage;

	public S27814BankApplication(ClientStorage clientStorage, WireTransferStorage wireTransferStorage, WireTransferService wireTransferService){
		this.clientStorage=clientStorage;
		this.wireTransferService=wireTransferService;
		this.wireTransferStorage=wireTransferStorage;
		//execProcess();
	}

	public static void main(String[] args) {
		SpringApplication.run(S27814BankApplication.class, args);
	}


	public void execProcess(){
		Client client1 = new Client(250,"park");
		clientStorage.addClient(client1);
		wireTransferService.addMoney(0,250);
		System.out.println(wireTransferService.getClientData(0));
		wireTransferService.makeWireTransfer(0,150);
		System.out.println(wireTransferService.getClientData(0));

	}
}
