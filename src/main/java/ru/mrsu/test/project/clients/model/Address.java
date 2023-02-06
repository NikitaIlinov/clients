package ru.mrsu.test.project.clients.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "house")
    private int house;
    @Column(name = "floor")
    private int floor;
    @Column(name = "flat_number")
    private int flatNumber;

    @OneToMany
    @JoinColumn(name="address_id")
    private List<Client> ids;
}
