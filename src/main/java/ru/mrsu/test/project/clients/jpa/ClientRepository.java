package ru.mrsu.test.project.clients.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mrsu.test.project.clients.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
