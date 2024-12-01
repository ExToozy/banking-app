package ru.extoozy.bankingapp.api.mapper;

import org.mapstruct.Mapper;
import ru.extoozy.bankingapp.api.dto.CardDto;
import ru.extoozy.bankingapp.domain.model.Card;

@Mapper(componentModel = "spring")
public interface CardMapper extends Mappable<Card, CardDto> {
}
