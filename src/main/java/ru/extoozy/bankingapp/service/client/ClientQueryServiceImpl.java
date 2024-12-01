package ru.extoozy.bankingapp.service.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.extoozy.bankingapp.domain.exception.ResourceNotFoundException;
import ru.extoozy.bankingapp.domain.model.Client;
import ru.extoozy.bankingapp.repository.ClientRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientQueryServiceImpl implements ClientQueryService {

    private final ClientRepository clientRepository;

    @Override
    public Client getById(UUID id) {
        return clientRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public boolean existsByUsername(String username) {
        return clientRepository.existsByUsername(username);
    }
}
