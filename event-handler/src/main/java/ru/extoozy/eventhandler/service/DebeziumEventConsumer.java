package ru.extoozy.eventhandler.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import ru.extoozy.eventhandler.handler.EventHandler;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class DebeziumEventConsumer implements CDCEventConsumer {

    private final Map<String, EventHandler> handlers;
    private final ObjectMapper mapper;

    @Override
    @KafkaListener(topics = "events")
    public void process(String payload, Acknowledgment acknowledgment) {
        try {
            JsonNode jsonObject = mapper.readTree(payload).get("payload");

            handlers.get(jsonObject.get("type").asText()).handle(jsonObject, acknowledgment);

            log.info("Message was handled: {}", payload);
        } catch (Exception e) {
            log.error("Error while handling message: ", e);
        }
    }
}
