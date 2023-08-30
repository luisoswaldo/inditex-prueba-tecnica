package com.inditex.prueba.domain.exeption;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class NotFoundExceptionTest {

    @Test
    void testConstructor() {
        NotFoundException actualNotFoundException = new NotFoundException(1, "An error occurred");

        assertNull(actualNotFoundException.getCause());
        assertEquals(0, actualNotFoundException.getSuppressed().length);
        assertEquals("An error occurred", actualNotFoundException.getMessage());
        assertEquals("An error occurred", actualNotFoundException.getLocalizedMessage());
        assertEquals(1, actualNotFoundException.getCode().intValue());
    }
}

