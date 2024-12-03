package ru.extoozy.eventhandler.service.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.extoozy.common.domain.model.Account;
import ru.extoozy.common.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Account create(Account account) {
        account.setBalance(BigDecimal.ZERO);
        account.setNumber(UUID.randomUUID().toString());

        return accountRepository.save(account);
    }
}
