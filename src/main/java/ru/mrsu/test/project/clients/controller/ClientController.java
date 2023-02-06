package ru.mrsu.test.project.clients.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mrsu.test.project.clients.jpa.AddressRepository;
import ru.mrsu.test.project.clients.jpa.ClientRepository;
import ru.mrsu.test.project.clients.model.Address;
import ru.mrsu.test.project.clients.model.Client;
import ru.mrsu.test.project.clients.service.ClientService;

import java.util.List;
@RestController
public class ClientController {
    private final ClientService clientService;
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;

    public ClientController(ClientService clientService,
                            ClientRepository clientRepository,
                            AddressRepository addressRepository){
        this.clientService = clientService;
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
    }

    @GetMapping("internal/clients")
    public List<Client> getClient(){
        return clientService.getClients();
    }

    @GetMapping("internal/setClients")
    public void setClient(){
        clientService.setClients();
    }

    @GetMapping("internal/getClientFromDB")
    public List<Client> getAddressFromDB(){
        return clientRepository.findAll();
    }

}
