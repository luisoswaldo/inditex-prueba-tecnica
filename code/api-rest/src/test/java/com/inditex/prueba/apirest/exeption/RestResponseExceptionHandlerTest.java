package com.inditex.prueba.apirest.exeption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.inditex.prueba.apirest.dto.ApiResponseDTO;
import com.inditex.prueba.domain.exeption.NotFoundException;

import java.lang.reflect.Executable;

import java.time.format.DateTimeParseException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

class RestResponseExceptionHandlerTest {

    @Test
    void testHandleNotFoundException() {
        RestResponseExceptionHandler restResponseExceptionHandler = new RestResponseExceptionHandler();
        NotFoundException ex = new NotFoundException(1, "An error occurred");

        ResponseEntity<Object> actualHandleNotFoundExceptionResult = restResponseExceptionHandler
                .handleNotFoundException(ex, new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualHandleNotFoundExceptionResult.hasBody());
        assertEquals(404, actualHandleNotFoundExceptionResult.getStatusCodeValue());
        assertTrue(actualHandleNotFoundExceptionResult.getHeaders().isEmpty());
        assertEquals(1, ((ApiResponseDTO) actualHandleNotFoundExceptionResult.getBody()).getCode().intValue());
        assertEquals("An error occurred", ((ApiResponseDTO) actualHandleNotFoundExceptionResult.getBody()).getMessage());
    }

    @Test
    void testHandleDateTimeParseException() {
        RestResponseExceptionHandler restResponseExceptionHandler = new RestResponseExceptionHandler();
        DateTimeParseException ex = new DateTimeParseException("Date could not be parsed", System.lineSeparator(), 1);

        ResponseEntity<Object> actualHandleNotFoundExceptionResult = restResponseExceptionHandler
                .handleNotFoundException(ex, new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualHandleNotFoundExceptionResult.hasBody());
        assertEquals(404, actualHandleNotFoundExceptionResult.getStatusCodeValue());
        assertTrue(actualHandleNotFoundExceptionResult.getHeaders().isEmpty());
        assertEquals(4001, ((ApiResponseDTO) actualHandleNotFoundExceptionResult.getBody()).getCode().intValue());
        assertEquals("Date could not be parsed",
                ((ApiResponseDTO) actualHandleNotFoundExceptionResult.getBody()).getMessage());
    }
}

