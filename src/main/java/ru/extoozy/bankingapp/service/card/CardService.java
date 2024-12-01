package ru.extoozy.bankingapp.service.card;

import ru.extoozy.bankingapp.domain.model.Card;
import ru.extoozy.bankingapp.service.CommandService;
import ru.extoozy.bankingapp.service.QueryService;

import java.util.UUID;

public interface CardService extends QueryService<Card>, CommandService<Card> {


    void createByClientId(UUID id);

    boolean existsByNumberAndDate(String number, String date);
}
