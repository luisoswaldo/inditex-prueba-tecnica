package com.inditex.prueba.infrastructure.repository.h2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrandEntityTest {

    @Test
    void testSetBrandId() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setBrandId(1);
        brandEntity.setName("Zara");
        Integer actualBrandId = brandEntity.getBrandId();
        String actualName = brandEntity.getName();
        assertEquals(1, actualBrandId.intValue());
        assertEquals("Zara", actualName);
    }


}

