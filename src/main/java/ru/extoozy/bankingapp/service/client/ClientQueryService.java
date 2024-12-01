package ru.extoozy.bankingapp.service.client;

import ru.extoozy.bankingapp.domain.model.Client;
import ru.extoozy.bankingapp.service.QueryService;

public interface ClientQueryService extends QueryService<Client> {
    boolean existsByUsername(String username);
}
