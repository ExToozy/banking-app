package ru.extoozy.bankingapp.service.account;

import ru.extoozy.bankingapp.domain.model.Account;
import ru.extoozy.bankingapp.service.CommandService;
import ru.extoozy.bankingapp.service.QueryService;

public interface AccountService extends QueryService<Account>, CommandService<Account> {


}
