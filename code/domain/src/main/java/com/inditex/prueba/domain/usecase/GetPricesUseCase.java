package com.inditex.prueba.domain.usecase;

import com.inditex.prueba.domain.model.PriceModel;

import java.time.LocalDateTime;

public interface GetPricesUseCase {
    PriceModel findPrice(LocalDateTime date, Integer productId, Integer brandId);

}
