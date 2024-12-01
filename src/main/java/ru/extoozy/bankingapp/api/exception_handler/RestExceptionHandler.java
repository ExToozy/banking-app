package ru.extoozy.bankingapp.api.exception_handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.extoozy.bankingapp.api.dto.MessageDto;
import ru.extoozy.bankingapp.domain.exception.ResourceAlreadyExistsException;
import ru.extoozy.bankingapp.domain.exception.ResourceNotFoundException;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MessageDto resourceNotFound(ResourceNotFoundException e) {
        return MessageDto.builder()
                .message(e.getMessage() != null
                        ? e.getMessage()
                        : "Not found"
                )
                .build();
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDto resourceAlreadyExists(ResourceAlreadyExistsException e) {
        return MessageDto.builder()
                .message(e.getMessage() != null
                        ? e.getMessage()
                        : "Already exists"
                )
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDto methodArgumentNotValid(MethodArgumentNotValidException e) {
        Map<String, String> errors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(
                        Collectors.toMap(
                                FieldError::getField,
                                DefaultMessageSourceResolvable::getDefaultMessage,
                                (existingMessage, newMessage) -> existingMessage + ", " + newMessage
                        )
                );
        return MessageDto.builder()
                .message("Validation failed")
                .errors(errors)
                .build();
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDto illegalState(IllegalStateException e) {
        return MessageDto.builder()
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public MessageDto exception(Exception e) {
        log.error("Internal server error: ", e);
        return MessageDto.builder().message("Internal server error").build();
    }

}
