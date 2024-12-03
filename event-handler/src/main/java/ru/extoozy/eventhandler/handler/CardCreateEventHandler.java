package ru.extoozy.eventhandler.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.extoozy.common.domain.model.Card;
import ru.extoozy.common.event.CardCreateEvent;
import ru.extoozy.eventhandler.service.card.CardService;

@Component("CARD_CREATE")
@RequiredArgsConstructor
public class CardCreateEventHandler implements EventHandler {

    private final CardService cardService;
    private final ObjectMapper mapper;

    @Override
    @Transactional
    public void handle(JsonNode object, Acknowledgment acknowledgment) throws JsonProcessingException {
        CardCreateEvent event = mapper.treeToValue(object, CardCreateEvent.class);
        Card card = mapper.readValue((String) event.getPayload(), Card.class);
        cardService.create(card);
        acknowledgment.acknowledge();
    }
}
