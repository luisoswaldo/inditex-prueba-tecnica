package com.inditex.prueba.apirest.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceDTOTest {

    @Test
    void testSetBrandId() {
        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setBrandId(1);
        priceDTO.setEndDate("2020-03-01");
        priceDTO.setPrice(10.0f);
        priceDTO.setPriceList(1);
        priceDTO.setProductId(1);
        priceDTO.setStartDate("2020-03-01");

        assertEquals(1, priceDTO.getBrandId());
        assertEquals("2020-03-01", priceDTO.getEndDate());
        assertEquals(10.0f, priceDTO.getPrice());
        assertEquals(1, priceDTO.getPriceList());
        assertEquals(1, priceDTO.getProductId());
        assertEquals("2020-03-01", priceDTO.getStartDate());
    }
}

