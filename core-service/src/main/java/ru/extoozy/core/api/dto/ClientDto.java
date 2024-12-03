package ru.extoozy.core.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDto {

    @NotNull(message = "Id must not be null", groups = OnUpdate.class)
    @Null(message = "Id must be null", groups = OnCreate.class)
    private UUID id;

    @NotNull(message = "Name must not be null")
    @Length(min = 1, max = 255, message = "Name must be between {min} and {max}")
    private String name;

    @Email(message = "Username must be a valid email")
    @NotNull(message = "Username must not be null")
    @Length(min = 1, max = 255, message = "Username must be between {min} and {max}")
    private String username;

    @NotNull(message = "Password must not be null")
    @Length(min = 1, max = 255, message = "Name must be between {min} and {max}")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

}
