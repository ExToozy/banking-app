package ru.extoozy.core.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.extoozy.core.api.dto.CardDto;
import ru.extoozy.core.api.dto.TransactionDto;
import ru.extoozy.core.api.mapper.CardMapper;
import ru.extoozy.core.api.mapper.TransactionMapper;
import ru.extoozy.core.api.security.SecurityUser;
import ru.extoozy.core.api.security.service.SecurityService;
import ru.extoozy.core.service.card.CardService;
import ru.extoozy.common.domain.model.Card;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {
    private final SecurityService securityService;

    private final CardService cardService;

    private final CardMapper cardMapper;

    private final TransactionMapper transactionMapper;

    @PostMapping
    public void create() {
        SecurityUser user = securityService.getUserFromRequest();
        UUID id = user.getId();
        cardService.createByClientId(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("@securityServiceImpl.canAccessCard(#id)")
    public CardDto getById(@PathVariable final UUID id) {
        Card card = cardService.getById(id);
        return cardMapper.toDto(card);
    }

    @GetMapping("/{cardId}/transactions")
    @PreAuthorize("@securityServiceImpl.canAccessCard(#cardId)")
    public List<TransactionDto> getTransactionsByCardId(@PathVariable final UUID cardId) {
        Card card = cardService.getById(cardId);
        return transactionMapper.toDto(card.getTransactions());
    }

}
