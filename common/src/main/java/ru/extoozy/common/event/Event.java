package ru.extoozy.common.event;


import ru.extoozy.common.domain.aggregate.Aggregate;

public interface Event {

    void apply(Aggregate aggregate);

}
