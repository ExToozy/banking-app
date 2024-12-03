package ru.extoozy.eventhandler.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.extoozy.common.domain.model.Account;
import ru.extoozy.common.event.AccountCreateEvent;
import ru.extoozy.eventhandler.service.account.AccountService;

@Component("ACCOUNT_CREATE")
@RequiredArgsConstructor
public class AccountCreateEventHandler implements EventHandler {

    private final AccountService accountService;
    private final ObjectMapper mapper;

    @Override
    @Transactional
    public void handle(JsonNode object, Acknowledgment acknowledgment) {
        try {
            AccountCreateEvent event = mapper.treeToValue(object, AccountCreateEvent.class);
            Account account = mapper.readValue((String) event.getPayload(), Account.class);
            accountService.create(account);
            acknowledgment.acknowledge();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
