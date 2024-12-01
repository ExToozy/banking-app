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
public class ClientCreateEvent extends AbstractEvent {
    public ClientCreateEvent(Object payload) {
        super(null, EventType.CLIENT_CREATE, payload);
    }

    @Override
    public void apply(Aggregate aggregate) {

    }
}
