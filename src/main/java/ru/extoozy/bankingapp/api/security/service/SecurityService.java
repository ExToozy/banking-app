package ru.extoozy.bankingapp.api.security.service;

import ru.extoozy.bankingapp.api.security.SecurityUser;
import ru.extoozy.bankingapp.domain.model.Card;

import java.util.UUID;

public interface SecurityService {

    SecurityUser getUserFromRequest();

    boolean canAccessClient(UUID clientId);

    boolean canAccessCard(UUID cardId);

    boolean canAccessCard(Card card);

    boolean canAccessTransaction(UUID transactionId);
}
