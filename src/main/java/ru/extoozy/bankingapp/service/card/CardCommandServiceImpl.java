package ru.extoozy.bankingapp.service.card;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.extoozy.bankingapp.domain.model.Card;
import ru.extoozy.bankingapp.event.CardCreateEvent;
import ru.extoozy.bankingapp.service.event.EventService;


@Service
@RequiredArgsConstructor
@Transactional
public class CardCommandServiceImpl implements CardCommandService {

    private final EventService eventService;

    @Override
    public void create(Card object) {
        CardCreateEvent event = new CardCreateEvent(object);
        eventService.create(event);
    }
}
