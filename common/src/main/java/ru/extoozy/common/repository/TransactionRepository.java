package ru.extoozy.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.extoozy.common.domain.model.Transaction;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
