package com.inditex.prueba.infrastructure.repository.impl;

import com.inditex.prueba.domain.exeption.DomainException;
import com.inditex.prueba.domain.exeption.NotFoundException;
import com.inditex.prueba.domain.model.PriceModel;
import com.inditex.prueba.domain.repository.PriceRepository;
import com.inditex.prueba.domain.util.ApplicationMessages;
import com.inditex.prueba.infrastructure.repository.PriceRepositoryJpa;
import com.inditex.prueba.infrastructure.repository.h2.PriceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.inditex.prueba.infrastructure.repository.mapper.PriceMapper.mapper;

@Repository
public class PriceRepositoryImpl implements PriceRepository {
    @Autowired
    private PriceRepositoryJpa priceRepositoryJpa;

    @Override
    public PriceModel findPrice(LocalDateTime appDate, Integer productId, Integer brandId) {
        final Integer id = 1;
        try {
            final Optional<PriceEntity> priceEntity = this.priceRepositoryJpa
                    .findPriceByDateAndProductIdAndBrandId(appDate, productId, brandId);
            if (priceEntity.isPresent()) {
                return mapper.asPrice(priceEntity.get());
            } else {
                throw new NotFoundException(ApplicationMessages.RECORD_NOT_FOUND.getCode(),
                        String.format(ApplicationMessages.RECORD_NOT_FOUND.getMessage(), id));
            }
        } catch (DataAccessException e) {
            throw new DomainException(ApplicationMessages.BD_ACCESS_ERROR.getCode(), ApplicationMessages.BD_ACCESS_ERROR.getMessage());
        }
    }


}
