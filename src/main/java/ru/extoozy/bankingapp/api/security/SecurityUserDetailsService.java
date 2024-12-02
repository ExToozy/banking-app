package ru.extoozy.bankingapp.api.security;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.extoozy.bankingapp.domain.model.Client;
import ru.extoozy.bankingapp.service.client.ClientService;

@Service
@RequiredArgsConstructor
public class SecurityUserDetailsService implements UserDetailsService {

    private final ClientService clientService;

    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String username) {
        Client client = clientService.getByUsername(username);
        return new SecurityUser(client);
    }
}
