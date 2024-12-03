package ru.extoozy.core.api.security;

import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.extoozy.common.domain.model.Client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
public class SecurityUser implements UserDetails {

    private final UUID id;
    private final String username;
    private final String password;
    private final Collection<SimpleGrantedAuthority> authorities;

    public SecurityUser(Client client) {
        id = client.getId();
        username = client.getUsername();
        password = client.getPassword();
        authorities = new ArrayList<>(List.of(mapToGrantedAuthorities("ROLE_USER")));
    }

    private SimpleGrantedAuthority mapToGrantedAuthorities(String role) {
        return new SimpleGrantedAuthority(role);
    }
}
