package ru.extoozy.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.extoozy.bankingapp.domain.model.Client;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
