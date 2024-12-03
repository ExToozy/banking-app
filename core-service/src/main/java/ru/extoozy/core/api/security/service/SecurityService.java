package ru.extoozy.core.api.security.service;

import ru.extoozy.core.api.security.SecurityUser;
import ru.extoozy.common.domain.model.Card;

import java.util.UUID;

public interface SecurityService {

    SecurityUser getUserFromRequest();

    boolean canAccessClient(UUID clientId);

    boolean canAccessCard(UUID cardId);

    boolean canAccessCard(Card card);

    boolean canAccessTransaction(UUID transactionId);
}
