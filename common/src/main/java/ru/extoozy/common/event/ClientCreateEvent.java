package ru.extoozy.common.event;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.extoozy.common.domain.aggregate.Aggregate;
import ru.extoozy.common.domain.model.Client;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ClientCreateEvent extends AbstractEvent {
    public ClientCreateEvent(Client payload) {
        super(null, EventType.CLIENT_CREATE, payload);
    }

    @Override
    public void apply(Aggregate aggregate) {

    }
}
