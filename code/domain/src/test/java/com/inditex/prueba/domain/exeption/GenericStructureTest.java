package com.inditex.prueba.domain.exeption;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class GenericStructureTest {

    @Test
    void testConstructor() {
        GenericStructure actualGenericStructure = new GenericStructure(1, "Generic Message");

        assertNull(actualGenericStructure.getCause());
        assertEquals(0, actualGenericStructure.getSuppressed().length);
        assertEquals("Generic Message", actualGenericStructure.getMessage());
        assertEquals("Generic Message", actualGenericStructure.getLocalizedMessage());
        assertEquals(1, actualGenericStructure.getCode().intValue());
    }
}

