package com.inditex.prueba.domain.repository;

import com.inditex.prueba.domain.exeption.DomainException;
import com.inditex.prueba.domain.exeption.NotFoundException;
import com.inditex.prueba.domain.model.PriceModel;

import java.time.LocalDateTime;

public interface PriceRepository {
    PriceModel findPrice(LocalDateTime date, Integer productId, Integer brandId) throws NotFoundException, DomainException;
}
