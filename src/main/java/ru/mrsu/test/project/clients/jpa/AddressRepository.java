package ru.mrsu.test.project.clients.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mrsu.test.project.clients.model.Address;

import java.util.List;


public interface AddressRepository extends JpaRepository<Address, Integer> {
    long countByHouse(int house);
    List<Address> findByStreet(String street);
}
