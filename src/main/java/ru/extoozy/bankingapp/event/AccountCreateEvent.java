package ru.extoozy.bankingapp.event;

import ru.extoozy.bankingapp.domain.aggregate.Aggregate;
import ru.extoozy.bankingapp.domain.model.Account;

public class AccountCreateEvent extends AbstractEvent {
    public AccountCreateEvent(Account payload) {
        super(null, EventType.ACCOUNT_CREATE, payload);
    }

    @Override
    public void apply(Aggregate aggregate) {

    }
}
