package com.inditex.prueba.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ContextConfiguration(classes = {DateTimeConfig.class})
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
class DateTimeConfigTest {
    @Autowired
    private DateTimeConfig dateTimeConfig;

    @Test
    void testMvcConversionService() {
        assertTrue(dateTimeConfig.mvcConversionService() instanceof DefaultFormattingConversionService);
    }
}

