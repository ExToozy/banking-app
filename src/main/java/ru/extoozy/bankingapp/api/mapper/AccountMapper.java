package ru.extoozy.bankingapp.api.mapper;

import org.mapstruct.Mapper;
import ru.extoozy.bankingapp.api.dto.AccountDto;
import ru.extoozy.bankingapp.domain.model.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper extends Mappable<Account, AccountDto> {
}
