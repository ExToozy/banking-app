package ru.extoozy.core.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.extoozy.core.api.dto.group.OnCreate;
import ru.extoozy.core.api.dto.group.OnUpdate;

import java.math.BigDecimal;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {

    @NotNull(message = "Id must not be null", groups = OnUpdate.class)
    @Null(message = "Id must be null", groups = OnCreate.class)
    private UUID id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String number;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private BigDecimal balance;

}
