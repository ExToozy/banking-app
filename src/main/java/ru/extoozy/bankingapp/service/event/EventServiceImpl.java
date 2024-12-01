package ru.extoozy.bankingapp.service.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.extoozy.bankingapp.event.AbstractEvent;
import ru.extoozy.bankingapp.repository.EventRepository;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public void create(AbstractEvent event) {
        eventRepository.save(event);
    }
}
