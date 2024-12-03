package ru.extoozy.common.event;


import ru.extoozy.common.domain.aggregate.Aggregate;
import ru.extoozy.common.domain.model.Account;

public class AccountCreateEvent extends AbstractEvent {
    public AccountCreateEvent(Account payload) {
        super(null, EventType.ACCOUNT_CREATE, payload);
    }

    @Override
    public void apply(Aggregate aggregate) {

    }
}
