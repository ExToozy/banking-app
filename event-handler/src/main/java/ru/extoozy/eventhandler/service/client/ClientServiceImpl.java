package ru.extoozy.eventhandler.service.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.extoozy.common.domain.model.Account;
import ru.extoozy.common.domain.model.Client;
import ru.extoozy.common.repository.ClientRepository;
import ru.extoozy.eventhandler.service.account.AccountService;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;
    private final AccountService accountService;

    @Override
    public Client create(Client client) {
        Account account = new Account();
        account = accountService.create(account);
        client.setAccount(account);

        return repository.save(client);
    }
}
