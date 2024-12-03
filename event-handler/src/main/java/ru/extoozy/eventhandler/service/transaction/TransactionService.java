package ru.extoozy.eventhandler.service.transaction;

import ru.extoozy.common.domain.model.Card;
import ru.extoozy.common.domain.model.Transaction;

import java.math.BigDecimal;

public interface TransactionService {
    Transaction create(Transaction transaction);

    void checkBalance(Card card, BigDecimal value);
}
