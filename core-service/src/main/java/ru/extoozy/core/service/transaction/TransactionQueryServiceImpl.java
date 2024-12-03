package ru.extoozy.core.service.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.extoozy.common.domain.exception.ResourceNotFoundException;
import ru.extoozy.common.domain.model.Transaction;
import ru.extoozy.common.repository.TransactionRepository;

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
