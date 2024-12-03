package ru.extoozy.core.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.extoozy.core.api.dto.group.OnCreate;
import ru.extoozy.core.api.dto.group.OnTransactionCardFrom;
import ru.extoozy.core.api.dto.group.OnTransactionCardTo;
import ru.extoozy.core.api.dto.group.OnUpdate;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardDto {

    @NotNull(message = "Id must not be null", groups = OnUpdate.class)
    @Null(message = "Id must be null", groups = OnCreate.class)
    private UUID id;

    @NotNull(
            message = "Number must not be null",
            groups = {OnCreate.class, OnTransactionCardTo.class, OnTransactionCardFrom.class}
    )
    @Null(message = "Number must be null", groups = OnUpdate.class)
    private String number;

    @NotNull(
            message = "Date must not be null",
            groups = {OnCreate.class, OnTransactionCardTo.class, OnTransactionCardFrom.class}
    )
    @Null(message = "Date must be null", groups = OnUpdate.class)
    private String date;

    @NotNull(message = "Card cvv must not be null", groups = {OnCreate.class, OnTransactionCardFrom.class})
    @Null(message = "Card cvv must be null", groups = {OnUpdate.class, OnTransactionCardTo.class})
    private String cvv;
}
