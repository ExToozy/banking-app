package ru.extoozy.core.service.card;


import ru.extoozy.core.service.CommandService;
import ru.extoozy.core.service.QueryService;
import ru.extoozy.common.domain.model.Card;

import java.util.UUID;

public interface CardService extends QueryService<Card>, CommandService<Card> {


    void createByClientId(UUID id);

    boolean existsByNumberAndDate(String number, String date);

    Card getByNumberAndDateAndCvv(String number, String date, String cvv);
}
