package com.inditex.prueba.apirest.exeption;

import com.inditex.prueba.apirest.dto.ApiResponseDTO;
import com.inditex.prueba.domain.exeption.NotFoundException;
import com.inditex.prueba.domain.util.ApplicationMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestResponseExceptionHandler  {
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ApiResponseDTO handleValidationExceptions(
          MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach(error -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });

    final ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
    apiResponseDTO.setCode(ApplicationMessages.VALIDATE_FILED_ERROR.getCode());
    apiResponseDTO.setMessage(String.format(ApplicationMessages.VALIDATE_FILED_ERROR.getMessage(), errors));
    return apiResponseDTO;
  }

  @ExceptionHandler(value = NotFoundException.class)
  protected ResponseEntity<Object> handleNotFoundException(final NotFoundException ex, final WebRequest request) {
    final ApiResponseDTO response = new ApiResponseDTO();
    response.setCode(ex.getCode());
    response.setMessage(ex.getMessage());
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = DateTimeParseException.class)
  protected ResponseEntity<Object> handleNotFoundException(final DateTimeParseException ex, final WebRequest request) {
    final ApiResponseDTO response = new ApiResponseDTO();
    response.setCode(ApplicationMessages.DATE_NOT_PARSED.getCode());
    response.setMessage(ApplicationMessages.DATE_NOT_PARSED.getMessage());
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

}
