package ru.extoozy.core.service.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.extoozy.common.domain.exception.ResourceNotFoundException;
import ru.extoozy.common.domain.model.Client;
import ru.extoozy.common.repository.ClientRepository;

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

    @Override
    public Client getByUsername(String username) {
        return clientRepository
                .findByUsername(username)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
