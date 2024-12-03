package ru.extoozy.core.service.card;

import ru.extoozy.core.service.QueryService;
import ru.extoozy.common.domain.model.Card;

public interface CardQueryService extends QueryService<Card> {
    boolean existsByNumberAndDate(String number, String date);

    Card getByNumberAndDateAndCvv(String number, String date, String cvv);
}
