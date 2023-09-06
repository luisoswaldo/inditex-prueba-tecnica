package com.inditex.prueba.usecase;

import com.inditex.prueba.domain.model.PriceModel;
import com.inditex.prueba.domain.repository.PriceRepository;
import com.inditex.prueba.domain.usecase.GetPricesUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GetPricesUseCaseImpl implements GetPricesUseCase {

    @Autowired
    PriceRepository priceRepository;

    @Override
    public PriceModel findPrice(final LocalDateTime date, final Integer productId, final Integer brandId) {
        return priceRepository.findPrice(date, productId, brandId);
    }
}
