package ru.extoozy.bankingapp.api.mapper;

import org.mapstruct.Mapper;
import ru.extoozy.bankingapp.api.dto.ClientDto;
import ru.extoozy.bankingapp.domain.model.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper extends Mappable<Client, ClientDto> {
}
