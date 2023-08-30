package com.inditex.prueba.domain.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceModelTest {

    @Test
    void testSetBrandId() {
        PriceModel priceModel = new PriceModel();
        priceModel.setBrandId(1);
        LocalDateTime startDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        priceModel.setStartDate(startDate);
        LocalDateTime endDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        priceModel.setEndDate(endDate);
        priceModel.setEndDate(endDate);
        priceModel.setPrice(10.0f);
        priceModel.setPriceList(1);
        priceModel.setProductId(1);

        assertEquals(1, priceModel.getBrandId());
        assertEquals(startDate, priceModel.getStartDate());
        assertEquals(endDate, priceModel.getEndDate());
        assertEquals(10.0f, priceModel.getPrice());
        assertEquals(1, priceModel.getPriceList());
        assertEquals(1, priceModel.getProductId());
    }
}

