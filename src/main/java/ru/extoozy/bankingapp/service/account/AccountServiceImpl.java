package ru.extoozy.bankingapp.service.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.extoozy.bankingapp.domain.model.Account;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountQueryService queryService;
    private final AccountCommandService commandService;


    @Override
    public void create(Account object) {
        commandService.create(object);
    }

    @Override
    public Account getById(UUID id) {
        return queryService.getById(id);
    }
}
