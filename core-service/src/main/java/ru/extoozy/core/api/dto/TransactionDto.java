package ru.extoozy.core.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDto {

    @NotNull(message = "Id must not be null", groups = OnUpdate.class)
    @Null(message = "Id must be null", groups = OnCreate.class)
    private UUID id;

    @NotNull(message = "Sender card from must not be null", groups = OnCreate.class)
    @Null(message = "Sender card must be null", groups = {OnCreate.class, OnUpdate.class})
    @Valid
    private CardDto from;

    @NotNull(message = "Receiver card from must not be null", groups = OnCreate.class)
    @Null(message = "Receiver must be null", groups = OnUpdate.class)
    @Valid
    private CardDto to;

    @NotNull(message = "Amount must not be null", groups = {OnCreate.class, OnUpdate.class})
    @Positive(message = "Amount must be positive", groups = {OnCreate.class, OnUpdate.class})
    private BigDecimal amount;

}
