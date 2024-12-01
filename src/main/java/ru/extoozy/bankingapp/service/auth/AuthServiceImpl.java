package ru.extoozy.bankingapp.service.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.extoozy.bankingapp.api.dto.LoginRequestDto;
import ru.extoozy.bankingapp.api.dto.LoginResponseDto;
import ru.extoozy.bankingapp.domain.exception.ResourceAlreadyExistsException;
import ru.extoozy.bankingapp.domain.model.Client;
import ru.extoozy.bankingapp.service.client.ClientService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private ClientService clientService;

    @Override
    public LoginResponseDto login(LoginRequestDto requestDto) {
        // TODO implement
        return null;
    }

    @Override
    public void register(Client client) {
        if (clientService.existsByUsername(client.getUsername())) {
            throw new ResourceAlreadyExistsException();
        }
        // TODO hash password
        client.setPassword(client.getPassword());

        clientService.create(client);
    }
}
