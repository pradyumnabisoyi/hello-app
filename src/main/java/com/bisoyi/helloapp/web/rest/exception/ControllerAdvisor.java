package com.bisoyi.helloapp.web.rest.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {
    private static final String INCOMING_REQUEST_MESSAGE = "Incoming request is not valid: {}";
    private static final String ERROR_ON_REQUEST = "Error processing a REST request. Error: {}";
    private static final Logger log = LoggerFactory.getLogger(ControllerAdvisor.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest request) {
        log.error(INCOMING_REQUEST_MESSAGE, ex);
        return new ResponseEntity<>(getBodyMessage(ex), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<Object> handleTaskNotFoundException(TaskNotFoundException ex, WebRequest request) {
        log.error(INCOMING_REQUEST_MESSAGE, ex);
        return new ResponseEntity<>(getBodyMessage(ex), HttpStatus.NOT_FOUND);
    }

    private Object getBodyMessage(Exception ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        body.put("errorClass", ex.getClass().getSimpleName());
        log.error(ERROR_ON_REQUEST, ex);
        return body;
    }
}
