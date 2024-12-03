package ru.extoozy.common.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.SneakyThrows;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    @Override
    @SneakyThrows
    public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) {
        return LocalDateTime.ofInstant(
                Instant.ofEpochMilli(
                        parser.getLongValue() / 1000
                ),
                TimeZone.getDefault().toZoneId()
        );
    }
}
