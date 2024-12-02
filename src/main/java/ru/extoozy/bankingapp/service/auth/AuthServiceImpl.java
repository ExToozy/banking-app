package ru.extoozy.bankingapp.service.auth;

import io.github.ilyalisov.jwt.config.TokenParameters;
import io.github.ilyalisov.jwt.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.extoozy.bankingapp.api.dto.LoginRequestDto;
import ru.extoozy.bankingapp.api.dto.LoginResponseDto;
import ru.extoozy.bankingapp.api.security.jwt.JwtProperties;
import ru.extoozy.bankingapp.api.security.jwt.TokenType;
import ru.extoozy.bankingapp.domain.exception.ResourceAlreadyExistsException;
import ru.extoozy.bankingapp.domain.model.Client;
import ru.extoozy.bankingapp.service.client.ClientService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ClientService clientService;

    private final TokenService tokenService;

    private final JwtProperties jwtProperties;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;


    @Override
    public LoginResponseDto login(LoginRequestDto loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        return LoginResponseDto
                .builder()
                .access(
                        tokenService.create(
                                TokenParameters
                                        .builder(
                                                loginRequest.getUsername(),
                                                TokenType.ACCESS.name(),
                                                jwtProperties.getAccess()
                                        )
                                        .build()
                        )
                )
                .refresh(
                        tokenService.create(
                                TokenParameters
                                        .builder(
                                                loginRequest.getUsername(),
                                                TokenType.REFRESH.name(),
                                                jwtProperties.getRefresh()
                                        )
                                        .build()
                        )
                )
                .build();
    }

    @Override
    public void register(Client client) {
        if (clientService.existsByUsername(client.getUsername())) {
            throw new ResourceAlreadyExistsException();
        }
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientService.create(client);
    }
}
