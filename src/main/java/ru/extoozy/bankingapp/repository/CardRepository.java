package ru.extoozy.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.extoozy.bankingapp.domain.model.Card;

import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {
}