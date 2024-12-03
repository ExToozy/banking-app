package ru.extoozy.eventhandler.service.card;

import ru.extoozy.common.domain.model.Card;

import java.math.BigDecimal;
import java.util.UUID;

public interface CardService {
    Card getById(UUID id);

    void addValue(Card card, BigDecimal value);

    Card create(Card card);

}
