package ru.extoozy.core.service.transaction;

import ru.extoozy.core.service.CommandService;
import ru.extoozy.core.service.QueryService;
import ru.extoozy.common.domain.model.Transaction;

public interface TransactionService extends QueryService<Transaction>, CommandService<Transaction> {


}
