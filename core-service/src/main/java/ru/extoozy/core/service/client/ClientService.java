package ru.extoozy.core.service.client;

import ru.extoozy.core.service.CommandService;
import ru.extoozy.core.service.QueryService;
import ru.extoozy.common.domain.model.Client;

public interface ClientService extends QueryService<Client>, CommandService<Client> {


    boolean existsByUsername(String username);

    Client getByUsername(String username);
}
