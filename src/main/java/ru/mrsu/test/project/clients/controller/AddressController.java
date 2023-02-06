package ru.mrsu.test.project.clients.controller;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mrsu.test.project.clients.jpa.AddressRepository;
import ru.mrsu.test.project.clients.model.Address;
import ru.mrsu.test.project.clients.service.AddressService;

import java.util.List;
@RestController
public class AddressController {
    private final AddressService addressService;
    private final AddressRepository addressRepository;

    public AddressController(AddressService addressService,
                             AddressRepository addressRepository){
        this.addressService = addressService;
        this.addressRepository = addressRepository;
    }

    @GetMapping("internal/address")
    public List<Address> getAddress(){
        return addressService.getAddress();
    }

    @GetMapping("internal/getAddressFromDB")
    public List<Address> getAddressFromDB(){
        return addressService.getAddress();
    }

    @GetMapping("internal/getAddressBlumenweg")
    public List<Address> getAddressBlumenweg(){
        return addressRepository.findByStreet("Blumenweg");
    }

    @GetMapping("internal/getAddressSort")
    public List<Address> getAddressSort() {
        return addressRepository.findAll(Sort.by("house"));
    }
}
