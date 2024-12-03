package ru.extoozy.core.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.extoozy.common.domain.model.Client;
import ru.extoozy.core.api.dto.ClientDto;
import ru.extoozy.core.api.dto.LoginRequestDto;
import ru.extoozy.core.api.dto.LoginResponseDto;
import ru.extoozy.core.api.dto.group.OnCreate;
import ru.extoozy.core.api.mapper.ClientMapper;
import ru.extoozy.core.service.auth.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    private final ClientMapper clientMapper;

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody @Validated LoginRequestDto loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public void register(@RequestBody @Validated(OnCreate.class) ClientDto dto) {
        Client client = clientMapper.toEntity(dto);
        authService.register(client);
    }

}
