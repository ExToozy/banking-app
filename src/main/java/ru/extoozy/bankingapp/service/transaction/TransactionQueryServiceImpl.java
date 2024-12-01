package ru.extoozy.bankingapp.service.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.extoozy.bankingapp.domain.exception.ResourceNotFoundException;
import ru.extoozy.bankingapp.domain.model.Transaction;
import ru.extoozy.bankingapp.repository.TransactionRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionQueryServiceImpl implements TransactionQueryService {

    private final TransactionRepository transactionRepository;

    @Override
    public Transaction getById(UUID id) {
        return transactionRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
