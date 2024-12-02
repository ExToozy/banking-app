package ru.extoozy.bankingapp.service.card;

import ru.extoozy.bankingapp.domain.model.Card;
import ru.extoozy.bankingapp.service.QueryService;

public interface CardQueryService extends QueryService<Card> {
    boolean existsByNumberAndDate(String number, String date);

    Card getByNumberAndDateAndCvv(String number, String date, String cvv);
}
