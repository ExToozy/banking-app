package ru.extoozy.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.extoozy.bankingapp.domain.model.Client;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
    boolean existsByUsername(String username);

    Optional<Client> findByUsername(String username);
}
