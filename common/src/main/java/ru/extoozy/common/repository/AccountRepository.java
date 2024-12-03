package ru.extoozy.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.extoozy.common.domain.model.Account;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}
