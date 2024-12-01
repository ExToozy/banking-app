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
public class CardCreateEvent extends AbstractEvent {
    public CardCreateEvent(Object payload) {
        super(null, EventType.CARD_CREATE, payload);
    }

    @Override
    public void apply(Aggregate aggregate) {

    }
}
