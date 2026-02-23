package com.example.managerstub.controller;

import com.example.managerstub.dto.ErrorMessageDto;
import com.example.managerstub.exception.DatabaseException;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {DatabaseException.class})
  public ResponseEntity<ErrorMessageDto> handleDBException(DatabaseException ex) {
    ErrorMessageDto errorMessage = ErrorMessageDto.builder()
        .message(ex.getMessage())
        .timestamp(LocalDateTime.now())
        .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .build();
    return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
