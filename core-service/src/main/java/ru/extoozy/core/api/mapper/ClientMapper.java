package ru.extoozy.core.api.mapper;

import org.mapstruct.Mapper;
import ru.extoozy.core.api.dto.ClientDto;
import ru.extoozy.common.domain.model.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper extends Mappable<Client, ClientDto> {
}
