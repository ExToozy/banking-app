package ru.extoozy.bankingapp.service.event;

import ru.extoozy.bankingapp.event.AbstractEvent;

public interface EventService {

    void create(AbstractEvent event);

}
