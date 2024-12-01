package ru.extoozy.bankingapp.service.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.extoozy.bankingapp.domain.model.Account;
import ru.extoozy.bankingapp.event.AccountCreateEvent;
import ru.extoozy.bankingapp.service.event.EventService;

@Service
@RequiredArgsConstructor
public class AccountCommandServiceImpl implements AccountCommandService {

    private final EventService eventService;

    @Override
    public void create(Account object) {
        AccountCreateEvent event = new AccountCreateEvent(object);
        eventService.create(event);
    }
}