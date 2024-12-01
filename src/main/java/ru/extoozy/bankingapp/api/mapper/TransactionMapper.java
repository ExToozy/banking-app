package ru.extoozy.bankingapp.api.mapper;

import org.mapstruct.Mapper;
import ru.extoozy.bankingapp.api.dto.TransactionDto;
import ru.extoozy.bankingapp.domain.model.Transaction;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends Mappable<Transaction, TransactionDto> {
}
