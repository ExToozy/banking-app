package ru.extoozy.bankingapp.service.card;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.extoozy.bankingapp.domain.exception.ResourceNotFoundException;
import ru.extoozy.bankingapp.domain.model.Card;
import ru.extoozy.bankingapp.repository.CardRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardQueryServiceImpl implements CardQueryService {

    private final CardRepository cardRepository;

    @Override
    public Card getById(UUID id) {
        return cardRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
