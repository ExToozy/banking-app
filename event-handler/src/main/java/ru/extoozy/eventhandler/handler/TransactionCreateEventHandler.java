package ru.extoozy.eventhandler.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.extoozy.common.domain.model.Transaction;
import ru.extoozy.common.event.TransactionCreateEvent;
import ru.extoozy.eventhandler.service.transaction.TransactionService;

@Component("TRANSACTION_CREATE")
@RequiredArgsConstructor
public class TransactionCreateEventHandler implements EventHandler {

    private final TransactionService transactionService;
    private final ObjectMapper mapper;


    @Override
    @Transactional
    public void handle(JsonNode object, Acknowledgment acknowledgment) throws JsonProcessingException {
        TransactionCreateEvent event = mapper.treeToValue(object, TransactionCreateEvent.class);
        Transaction transaction = mapper.readValue((String) event.getPayload(), Transaction.class);
        transactionService.create(transaction);
        acknowledgment.acknowledge();
    }
}
