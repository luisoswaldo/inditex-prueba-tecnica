package com.inditex.prueba.infrastructure.repository.impl;

import com.inditex.prueba.domain.exeption.NotFoundException;
import com.inditex.prueba.domain.model.PriceModel;
import com.inditex.prueba.infrastructure.repository.PriceRepositoryJpa;
import com.inditex.prueba.infrastructure.repository.h2.BrandEntity;
import com.inditex.prueba.infrastructure.repository.h2.PriceEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {PriceRepositoryImpl.class})
@ExtendWith(SpringExtension.class)
class PriceRepositoryImplTest {
    @MockBean
    private PriceRepositoryJpa priceRepositoryJpa;

    @Autowired
    private PriceRepositoryImpl priceRepositoryimpl;

    @Test
    void testFindPrice() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setBrandId(1);
        brandEntity.setName("Zara");

        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setBrandEntity(brandEntity);
        priceEntity.setCurr("EUR");
        priceEntity.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        priceEntity.setPrice(10.0f);
        priceEntity.setPriceList(1);
        priceEntity.setPriority(1);
        priceEntity.setProductId(1);
        priceEntity.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        Optional<PriceEntity> ofResult = Optional.of(priceEntity);
        when(priceRepositoryJpa.findPriceByDateAndProductIdAndBrandId(Mockito.any(), Mockito.any(),
                Mockito.any())).thenReturn(ofResult);
        PriceModel actualFindPriceResult = priceRepositoryimpl.findPrice(LocalDate.of(1970, 1, 1).atStartOfDay(), 1, 1);
        assertEquals(1, actualFindPriceResult.getBrandId());
        assertEquals(1, actualFindPriceResult.getProductId());
        assertEquals("1970-01-01T00:00", actualFindPriceResult.getStartDate().toString());
        assertEquals(1, actualFindPriceResult.getPriceList());
        assertEquals(10.0f, actualFindPriceResult.getPrice());
        assertEquals("1970-01-01T00:00", actualFindPriceResult.getEndDate().toString());
        verify(priceRepositoryJpa).findPriceByDateAndProductIdAndBrandId(Mockito.any(),
                Mockito.any(), Mockito.any());
    }

    @Test
    void testFindPriceThrowsNotFoundException() {
        Optional<PriceEntity> emptyResult = Optional.empty();
        when(priceRepositoryJpa.findPriceByDateAndProductIdAndBrandId(Mockito.any(),
                Mockito.any(), Mockito.any())).thenReturn(emptyResult);
        assertThrows(NotFoundException.class,
                () -> priceRepositoryimpl.findPrice(LocalDate.of(1970, 1, 1).atStartOfDay(), 1, 1));
        verify(priceRepositoryJpa).findPriceByDateAndProductIdAndBrandId(Mockito.any(),
                Mockito.any(), Mockito.any());
    }
}

