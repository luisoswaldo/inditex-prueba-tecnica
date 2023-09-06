package com.inditex.prueba.infrastructure.repository.impl;

import com.inditex.prueba.domain.exeption.DomainException;
import com.inditex.prueba.domain.exeption.NotFoundException;
import com.inditex.prueba.domain.model.PriceModel;
import com.inditex.prueba.domain.repository.PriceRepository;
import com.inditex.prueba.domain.util.ApplicationMessages;
import com.inditex.prueba.infrastructure.repository.PriceRepositoryJpa;
import com.inditex.prueba.infrastructure.repository.entity.PriceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

import static com.inditex.prueba.infrastructure.repository.mapper.PriceMapper.mapper;

@Repository
public class PriceRepositoryImpl implements PriceRepository {
    @Autowired
    private PriceRepositoryJpa priceRepositoryJpa;

    @Override
    public PriceModel findPrice(final LocalDateTime appDate, final Integer productId, final Integer brandId)
            throws NotFoundException {
        try {
            Pageable pageable = PageRequest.of(0, 1);
            Page<PriceEntity> priceEntity =  this.priceRepositoryJpa
                    .findPriceByDateAndProductIdAndBrandId(appDate, productId, brandId, pageable);

            if (priceEntity.getTotalElements() == 1) {
                return mapper.asPrice(priceEntity.getContent().get(0));
            } else {
                throw new NotFoundException(ApplicationMessages.RECORD_NOT_FOUND.getCode(),
                        ApplicationMessages.RECORD_NOT_FOUND.getMessage());
            }
        } catch (DataAccessException e) {
            throw new DomainException(ApplicationMessages.BD_ACCESS_ERROR.getCode(), ApplicationMessages.BD_ACCESS_ERROR.getMessage());
        }
    }


}
