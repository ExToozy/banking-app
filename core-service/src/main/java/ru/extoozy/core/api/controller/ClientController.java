package ru.extoozy.core.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.extoozy.core.api.dto.AccountDto;
import ru.extoozy.core.api.dto.CardDto;
import ru.extoozy.core.api.dto.ClientDto;
import ru.extoozy.core.api.mapper.AccountMapper;
import ru.extoozy.core.api.mapper.CardMapper;
import ru.extoozy.core.api.mapper.ClientMapper;
import ru.extoozy.core.service.client.ClientService;
import ru.extoozy.common.domain.model.Client;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;
    private final CardMapper cardMapper;
    private final AccountMapper accountMapper;

    @GetMapping("/{id}")
    @PreAuthorize("@securityServiceImpl.canAccessClient(#id)")
    public ClientDto getById(@PathVariable UUID id) {
        Client client = clientService.getById(id);
        return clientMapper.toDto(client);
    }

    @GetMapping("/{id}/cards")
    @PreAuthorize("@securityServiceImpl.canAccessClient(#id)")
    public List<CardDto> getCardsByClientId(@PathVariable UUID id) {
        Client client = clientService.getById(id);
        return cardMapper.toDto(client.getCards());
    }

    @GetMapping("/{id}/account")
    @PreAuthorize("@securityServiceImpl.canAccessClient(#id)")
    public AccountDto getAccountByClientId(@PathVariable UUID id) {
        Client client = clientService.getById(id);
        return accountMapper.toDto(client.getAccount());
    }

}
