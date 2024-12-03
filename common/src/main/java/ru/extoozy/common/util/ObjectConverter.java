package ru.extoozy.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
@Converter
@RequiredArgsConstructor
public class ObjectConverter implements AttributeConverter<Object, String> {

    public final ObjectMapper mapper;

    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(Object attribute) {
        return mapper.writeValueAsString(attribute);
    }

    @SneakyThrows
    @Override
    public Object convertToEntityAttribute(String dbData) {
        return mapper.convertValue(dbData, Object.class);
    }
}
