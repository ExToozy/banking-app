package ru.extoozy.core.api.mapper;

import org.mapstruct.Mapper;
import ru.extoozy.core.api.dto.TransactionDto;
import ru.extoozy.common.domain.model.Transaction;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends Mappable<Transaction, TransactionDto> {


}
