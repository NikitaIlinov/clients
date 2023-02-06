package ru.mrsu.test.project.clients.service.impl;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import ru.mrsu.test.project.clients.jpa.AddressRepository;
import ru.mrsu.test.project.clients.jpa.ClientRepository;
import ru.mrsu.test.project.clients.model.Address;
import ru.mrsu.test.project.clients.service.AddressService;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {
    private final ResourceLoader resourceLoader;
    private final AddressRepository addressRepository;
    private final ClientRepository clientRepository;

    public AddressServiceImpl(ResourceLoader resourceLoader,
                              AddressRepository addressRepository,
                              ClientRepository clientRepository) {
        this.resourceLoader = resourceLoader;
        this.addressRepository = addressRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Address> getAddress(){
        return addressRepository.findAll();
    }
}
