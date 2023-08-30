package com.inditex.prueba.domain.exeption;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DomainExceptionTest {

    @Test
    void testConstructor() {
        DomainException actualDomainException = new DomainException(1, "An error occurred");

        assertNull(actualDomainException.getCause());
        assertEquals(0, actualDomainException.getSuppressed().length);
        assertEquals("An error occurred", actualDomainException.getMessage());
        assertEquals("An error occurred", actualDomainException.getLocalizedMessage());
        assertEquals(1, actualDomainException.getCode().intValue());
    }
}

