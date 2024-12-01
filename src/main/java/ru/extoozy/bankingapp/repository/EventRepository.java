package ru.extoozy.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.extoozy.bankingapp.event.AbstractEvent;

public interface EventRepository extends JpaRepository<AbstractEvent, Long> {
}
