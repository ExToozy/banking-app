package ru.extoozy.bankingapp.service.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.extoozy.bankingapp.domain.model.Client;
import ru.extoozy.bankingapp.event.ClientCreateEvent;
import ru.extoozy.bankingapp.service.event.EventService;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientCommandServiceImpl implements ClientCommandService {

    private final EventService eventService;

    @Override
    public void create(Client object) {
        ClientCreateEvent event = new ClientCreateEvent(object);
        eventService.create(event);
    }
}
