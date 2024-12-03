package ru.extoozy.eventhandler.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.kafka.support.Acknowledgment;

public interface EventHandler {

    void handle(JsonNode object, Acknowledgment acknowledgment) throws JsonProcessingException;

}
