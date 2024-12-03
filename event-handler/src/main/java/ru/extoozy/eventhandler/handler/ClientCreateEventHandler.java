package ru.extoozy.eventhandler.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.extoozy.common.domain.model.Client;
import ru.extoozy.common.event.CardCreateEvent;
import ru.extoozy.eventhandler.service.client.ClientService;

@Component("CLIENT_CREATE")
@RequiredArgsConstructor
public class ClientCreateEventHandler implements EventHandler {

    private final ClientService clientService;
    private final ObjectMapper mapper;

    @Override
    @Transactional
    public void handle(JsonNode object, Acknowledgment acknowledgment) {
        try {
            CardCreateEvent event = mapper.treeToValue(object, CardCreateEvent.class);
            Client client = mapper.readValue((String) event.getPayload(), Client.class);
            clientService.create(client);
            acknowledgment.acknowledge();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
