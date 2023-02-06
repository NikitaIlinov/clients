package ru.mrsu.test.project.clients.service;

import ru.mrsu.test.project.clients.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> getClients();
    void setClients();
}
