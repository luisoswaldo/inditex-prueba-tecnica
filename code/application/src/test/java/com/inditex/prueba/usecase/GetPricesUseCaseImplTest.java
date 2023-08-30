package com.inditex.prueba.usecase;

import com.inditex.prueba.domain.model.PriceModel;
import com.inditex.prueba.domain.repository.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {GetPricesUseCaseImpl.class})
@ExtendWith(SpringExtension.class)
class GetPricesUseCaseImplTest {
    @Autowired
    private GetPricesUseCaseImpl getPricesUseCaseImpl;

    @MockBean
    private PriceRepository priceRepository;

    @Test
    void testFindPrice() {
        PriceModel priceModel = new PriceModel();
        priceModel.setBrandId(1);
        priceModel.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        priceModel.setPrice(10.0f);
        priceModel.setPriceList(1);
        priceModel.setProductId(1);
        priceModel.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        when(priceRepository.findPrice(Mockito.any(), Mockito.any(), Mockito.any()))
                .thenReturn(priceModel);
        assertSame(priceModel, getPricesUseCaseImpl.findPrice(LocalDate.of(1970, 1, 1).atStartOfDay(), 1, 1));
        verify(priceRepository).findPrice(Mockito.any(), Mockito.any(), Mockito.any());
    }
}

