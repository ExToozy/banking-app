package ru.extoozy.core.service.account;

import ru.extoozy.core.service.CommandService;
import ru.extoozy.core.service.QueryService;
import ru.extoozy.common.domain.model.Account;

public interface AccountService extends QueryService<Account>, CommandService<Account> {


}
