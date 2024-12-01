package ru.extoozy.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.extoozy.bankingapp.domain.model.Account;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}
