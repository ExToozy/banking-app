package ru.extoozy.core.api.security.service;

import ru.extoozy.core.api.dto.CardDto;
import ru.extoozy.core.api.security.SecurityUser;

import java.util.UUID;

public interface SecurityService {

    SecurityUser getUserFromRequest();

    boolean canAccessClient(UUID clientId);

    boolean canAccessCard(UUID cardId);

    boolean canAccessCard(CardDto card);

    boolean canAccessTransaction(UUID transactionId);
}
