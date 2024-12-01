package ru.extoozy.bankingapp.event;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.extoozy.bankingapp.domain.aggregate.Aggregate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TransactionCreateEvent extends AbstractEvent {
    public TransactionCreateEvent(Object payload) {
        super(null, EventType.TRANSACTION_CREATE, payload);
    }

    @Override
    public void apply(Aggregate aggregate) {

    }
}
