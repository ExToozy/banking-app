package ru.extoozy.core.api.mapper;

import org.mapstruct.Mapper;
import ru.extoozy.core.api.dto.CardDto;
import ru.extoozy.common.domain.model.Card;

@Mapper(componentModel = "spring")
public interface CardMapper extends Mappable<Card, CardDto> {
}
