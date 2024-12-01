package ru.extoozy.bankingapp.service.client;

import ru.extoozy.bankingapp.domain.model.Client;
import ru.extoozy.bankingapp.service.CommandService;
import ru.extoozy.bankingapp.service.QueryService;

public interface ClientService extends QueryService<Client>, CommandService<Client> {


    boolean existsByUsername(String username);
}
