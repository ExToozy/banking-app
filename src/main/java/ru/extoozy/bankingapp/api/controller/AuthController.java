package ru.extoozy.bankingapp.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.extoozy.bankingapp.api.dto.ClientDto;
import ru.extoozy.bankingapp.api.dto.LoginRequestDto;
import ru.extoozy.bankingapp.api.dto.LoginResponseDto;
import ru.extoozy.bankingapp.api.dto.OnCreate;
import ru.extoozy.bankingapp.api.mapper.ClientMapper;
import ru.extoozy.bankingapp.domain.model.Client;
import ru.extoozy.bankingapp.service.auth.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    private final ClientMapper clientMapper;

    @PostMapping("/register")
    public void register(@RequestBody @Validated(OnCreate.class) ClientDto dto) {
        Client client = clientMapper.toEntity(dto);
        authService.register(client);
    }


    @PostMapping("/register")
    public LoginResponseDto register(@RequestBody @Validated LoginRequestDto dto) {
        return authService.login(dto);
    }
}
