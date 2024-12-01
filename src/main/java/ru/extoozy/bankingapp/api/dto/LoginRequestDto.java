package ru.extoozy.bankingapp.api.dto;

import jakarta.validation.constraints.NotNull;

public class LoginRequestDto {

    @NotNull(message = "Username must not be null")
    private String username;

    @NotNull(message = "Password must not be null")
    private String password;

}
