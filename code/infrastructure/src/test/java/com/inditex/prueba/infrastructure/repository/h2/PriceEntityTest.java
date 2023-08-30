package com.inditex.prueba.infrastructure.repository.h2;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class PriceEntityTest {

    @Test
    void testSetBrandEntity() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setBrandId(1);
        brandEntity.setName("ZARA");

        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setBrandEntity(brandEntity);
        priceEntity.setCurr("EUR");
        LocalDateTime endDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        priceEntity.setEndDate(endDate);
        priceEntity.setPrice(10.0f);
        priceEntity.setPriceList(1);
        priceEntity.setPriority(1);
        priceEntity.setProductId(1);
        LocalDateTime startDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        priceEntity.setStartDate(startDate);


        assertSame(brandEntity, priceEntity.getBrandEntity());
        assertEquals("EUR", priceEntity.getCurr());
        assertSame(endDate, priceEntity.getEndDate());
        assertEquals(10.0f, priceEntity.getPrice());
        assertEquals(1, priceEntity.getPriceList());
        assertEquals(1, priceEntity.getPriority());
        assertEquals(1, priceEntity.getProductId());
        assertSame(startDate, priceEntity.getStartDate());
    }
}

