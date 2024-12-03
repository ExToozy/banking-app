package ru.extoozy.core.api.mapper;

import org.mapstruct.Mapper;
import ru.extoozy.core.api.dto.AccountDto;
import ru.extoozy.common.domain.model.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper extends Mappable<Account, AccountDto> {
}
