package ru.extoozy.bankingapp.service.auth;

import ru.extoozy.bankingapp.api.dto.LoginRequestDto;
import ru.extoozy.bankingapp.api.dto.LoginResponseDto;
import ru.extoozy.bankingapp.domain.model.Client;


public interface AuthService {

    LoginResponseDto login(LoginRequestDto requestDto);

    void register(Client client);
}
