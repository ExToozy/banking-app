package ru.extoozy.bankingapp.service.transaction;

import ru.extoozy.bankingapp.domain.model.Transaction;
import ru.extoozy.bankingapp.service.CommandService;
import ru.extoozy.bankingapp.service.QueryService;

public interface TransactionService extends QueryService<Transaction>, CommandService<Transaction> {


}
