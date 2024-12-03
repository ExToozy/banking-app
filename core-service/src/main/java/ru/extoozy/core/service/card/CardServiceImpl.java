package ru.extoozy.core.service.card;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.extoozy.core.service.client.ClientService;
import ru.extoozy.common.domain.model.Card;
import ru.extoozy.common.domain.model.Client;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardQueryService queryService;
    private final CardCommandService commandService;
    private final ClientService clientService;

    @Override
    public void create(Card object) {
        commandService.create(object);
    }

    @Override
    public Card getById(UUID id) {
        return queryService.getById(id);
    }

    @Override
    public void createByClientId(UUID id) {
        Client client = clientService.getById(id);
        Card card = Card.builder()
                .account(client.getAccount())
                .build();

        commandService.create(card);
    }

    @Override
    public boolean existsByNumberAndDate(String number, String date) {
        return queryService.existsByNumberAndDate(number, date);
    }

    @Override
    public Card getByNumberAndDateAndCvv(String number, String date, String cvv) {
        return queryService.getByNumberAndDateAndCvv(number, date, cvv);
    }
}
