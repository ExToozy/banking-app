package ru.extoozy.bankingapp.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.extoozy.bankingapp.api.dto.OnCreate;
import ru.extoozy.bankingapp.api.dto.TransactionDto;
import ru.extoozy.bankingapp.api.mapper.TransactionMapper;
import ru.extoozy.bankingapp.domain.model.Transaction;
import ru.extoozy.bankingapp.service.card.CardService;
import ru.extoozy.bankingapp.service.transaction.TransactionService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final CardService cardService;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public void create(@RequestBody @Validated(OnCreate.class) TransactionDto dto) {
        if (!cardService.existsByNumberAndDate(dto.getTo().getNumber(), dto.getTo().getDate())) {
            throw new IllegalStateException("Card does not exists");
        }
        Transaction transaction = transactionMapper.toEntity(dto);
        transactionService.create(transaction);

    }

    @GetMapping("/{id}")
    public TransactionDto getById(@PathVariable UUID id) {
        Transaction transaction = transactionService.getById(id);
        return transactionMapper.toDto(transaction);
    }

}
