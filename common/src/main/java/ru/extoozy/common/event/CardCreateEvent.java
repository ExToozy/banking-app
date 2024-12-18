package ru.extoozy.common.event;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.extoozy.common.domain.aggregate.Aggregate;
import ru.extoozy.common.domain.model.Card;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CardCreateEvent extends AbstractEvent {
    public CardCreateEvent(Card payload) {
        super(null, EventType.CARD_CREATE, payload);
    }

    @Override
    public void apply(Aggregate aggregate) {

    }
}
