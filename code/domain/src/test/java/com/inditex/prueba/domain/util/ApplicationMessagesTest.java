package com.inditex.prueba.domain.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationMessagesTest {

    @Test
    void testGetCode() {
        ApplicationMessages valueOfResult = ApplicationMessages.valueOf("BD_ACCESS_ERROR");
        int actualCode = valueOfResult.getCode();
        assertEquals(5001, actualCode);
        assertEquals("Error trying to access the database.", valueOfResult.getMessage());
    }
}

