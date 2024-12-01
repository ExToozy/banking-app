package ru.extoozy.bankingapp.event;

import ru.extoozy.bankingapp.domain.aggregate.Aggregate;

public interface Event {

    void apply(Aggregate aggregate);

}
