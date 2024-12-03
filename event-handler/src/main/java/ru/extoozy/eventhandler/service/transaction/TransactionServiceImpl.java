package ru.extoozy.eventhandler.service.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.extoozy.common.domain.model.Card;
import ru.extoozy.common.domain.model.Transaction;
import ru.extoozy.common.repository.TransactionRepository;
import ru.extoozy.eventhandler.service.card.CardService;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final CardService cardService;

    @Override
    public Transaction create(Transaction transaction) {

        Card cardFrom = cardService.getById(transaction.getFrom().getId());
        Card cardTo = cardService.getById(transaction.getTo().getId());

        checkBalance(cardFrom, transaction.getAmount());

        cardService.addValue(cardFrom, transaction.getAmount().negate());
        cardService.addValue(cardTo, transaction.getAmount());

        return transactionRepository.save(transaction);
    }

    @Override
    public void checkBalance(Card card, BigDecimal value) {
        if (card.getAccount().getBalance().compareTo(value) < 0) {
            throw new IllegalStateException("Not enough money");
        }
    }
}
