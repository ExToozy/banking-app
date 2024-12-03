package ru.extoozy.core.service.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.extoozy.common.domain.exception.ResourceNotFoundException;
import ru.extoozy.common.domain.model.Account;
import ru.extoozy.common.repository.AccountRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountQueryServiceImpl implements AccountQueryService {

    private final AccountRepository accountRepository;

    @Override
    public Account getById(UUID id) {
        return accountRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
