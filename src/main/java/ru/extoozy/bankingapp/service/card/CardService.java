package ru.extoozy.bankingapp.service.card;

import ru.extoozy.bankingapp.domain.model.Card;
import ru.extoozy.bankingapp.service.CommandService;
import ru.extoozy.bankingapp.service.QueryService;

public interface CardService extends QueryService<Card>, CommandService<Card> {


}
