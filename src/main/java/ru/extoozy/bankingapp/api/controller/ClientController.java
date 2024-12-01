package ru.extoozy.bankingapp.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.extoozy.bankingapp.api.dto.AccountDto;
import ru.extoozy.bankingapp.api.dto.CardDto;
import ru.extoozy.bankingapp.api.dto.ClientDto;
import ru.extoozy.bankingapp.api.mapper.AccountMapper;
import ru.extoozy.bankingapp.api.mapper.CardMapper;
import ru.extoozy.bankingapp.api.mapper.ClientMapper;
import ru.extoozy.bankingapp.domain.model.Client;
import ru.extoozy.bankingapp.service.client.ClientService;

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
    public ClientDto getById(@PathVariable UUID id) {
        Client client = clientService.getById(id);
        return clientMapper.toDto(client);
    }

    @GetMapping("/{id}/cards")
    public List<CardDto> getCardsByClientId(@PathVariable UUID id) {
        Client client = clientService.getById(id);
        return cardMapper.toDto(client.getCards());
    }

    @GetMapping("/{id}/account")
    public AccountDto getAccountByClientId(@PathVariable UUID id) {
        Client client = clientService.getById(id);
        return accountMapper.toDto(client.getAccount());
    }

}
