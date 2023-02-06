package ru.mrsu.test.project.clients.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
public class Client {
        @Id
        @Column(name = "id")
        private int id;
        @Column(name = "client_name")
        private String name;
        @Column(name = "personnel_number")
        private String personnelNumber;
        @Column(name = "address_id")
        private int addressId;
}
