package ru.extoozy.bankingapp.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.extoozy.bankingapp.api.dto.CardDto;
import ru.extoozy.bankingapp.api.dto.TransactionDto;
import ru.extoozy.bankingapp.api.mapper.CardMapper;
import ru.extoozy.bankingapp.api.mapper.TransactionMapper;
import ru.extoozy.bankingapp.domain.model.Card;
import ru.extoozy.bankingapp.service.card.CardService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    private final CardMapper cardMapper;

    private final TransactionMapper transactionMapper;

    @PostMapping
    public void create() {
        // TODO fix it
        UUID id = UUID.randomUUID();
        cardService.createByClientId(id);
    }

    @GetMapping("/{id}")
    public CardDto getById(@PathVariable final UUID id) {
        Card card = cardService.getById(id);
        return cardMapper.toDto(card);
    }

    @GetMapping("/{id}/transactions")
    public List<TransactionDto> getTransactionsByCardId(@PathVariable final UUID id) {
        Card card = cardService.getById(id);
        return transactionMapper.toDto(card.getTransactions());
    }


}
