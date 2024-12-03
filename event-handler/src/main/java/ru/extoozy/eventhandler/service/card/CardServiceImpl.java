package ru.extoozy.eventhandler.service.card;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.extoozy.common.domain.exception.ResourceNotFoundException;
import ru.extoozy.common.domain.model.Account;
import ru.extoozy.common.domain.model.Card;
import ru.extoozy.common.repository.CardRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final Random random = new Random();

    @Override
    public Card getById(UUID id) {
        return cardRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void addValue(Card card, BigDecimal value) {
        Account account = card.getAccount();
        BigDecimal currentBalance = account.getBalance();
        account.setBalance(currentBalance.add(value));
        cardRepository.save(card);
    }

    @Override
    public Card create(Card card) {
        card.setNumber(generateCardNumber());
        card.setDate(getCardExpirationDate());
        card.setCvv(generateCvv());

        return cardRepository.save(card);
    }

    private String generateCardNumber() {
        return "%d%d%d%d".formatted(
                random.nextInt(1000, 9999),
                random.nextInt(1000, 9999),
                random.nextInt(1000, 9999),
                random.nextInt(1000, 9999)
        );
    }

    private String getCardExpirationDate() {
        LocalDate dateAfter5Years = LocalDate.now().plusYears(5);
        int dayOfMonth = dateAfter5Years.getDayOfMonth();
        int year = dateAfter5Years.getYear();
        return "%d/%d".formatted(dayOfMonth, year);
    }

    private String generateCvv() {
        return "%d".formatted(random.nextInt(100, 999));
    }
}
