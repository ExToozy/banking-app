package ru.extoozy.core.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.extoozy.core.api.dto.OnCreate;
import ru.extoozy.core.api.dto.TransactionDto;
import ru.extoozy.core.api.mapper.TransactionMapper;
import ru.extoozy.core.service.card.CardService;
import ru.extoozy.core.service.transaction.TransactionService;
import ru.extoozy.common.domain.model.Transaction;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final CardService cardService;
    private final TransactionMapper transactionMapper;

    @PostMapping
    @PreAuthorize("@securityServiceImpl.canAccessCard(#dto.from)")
    public void create(@RequestBody @Validated(OnCreate.class) TransactionDto dto) {
        if (!cardService.existsByNumberAndDate(dto.getTo().getNumber(), dto.getTo().getDate())) {
            throw new IllegalStateException("Card does not exists");
        }
        Transaction transaction = transactionMapper.toEntity(dto);
        transactionService.create(transaction);

    }

    @GetMapping("/{id}")
    @PreAuthorize("@securityServiceImpl.canAccessTransaction(#id)")
    public TransactionDto getById(@PathVariable UUID id) {
        Transaction transaction = transactionService.getById(id);
        return transactionMapper.toDto(transaction);
    }

}
