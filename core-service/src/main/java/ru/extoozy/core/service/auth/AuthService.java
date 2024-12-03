package ru.extoozy.core.service.auth;

import ru.extoozy.core.api.dto.LoginRequestDto;
import ru.extoozy.core.api.dto.LoginResponseDto;
import ru.extoozy.common.domain.model.Client;


public interface AuthService {

    LoginResponseDto login(LoginRequestDto requestDto);

    void register(Client client);
}
