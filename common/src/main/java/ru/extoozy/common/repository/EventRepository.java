package ru.extoozy.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.extoozy.common.event.AbstractEvent;

public interface EventRepository extends JpaRepository<AbstractEvent, Long> {
}
