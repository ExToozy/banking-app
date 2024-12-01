package ru.extoozy.bankingapp.service.card;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.extoozy.bankingapp.domain.model.Card;
import ru.extoozy.bankingapp.domain.model.Client;
import ru.extoozy.bankingapp.service.client.ClientService;

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
}
