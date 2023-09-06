package com.inditex.prueba.infrastructure.repository.mapper;

import com.inditex.prueba.domain.model.PriceModel;
import com.inditex.prueba.infrastructure.repository.entity.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PriceMapper {

    PriceMapper mapper = Mappers.getMapper(PriceMapper.class);

    List<PriceModel> asPrices(List<PriceEntity> pricesEntity);
    @Mapping(target = "brandId", expression = "java(priceEntity.getBrandEntity().getBrandId())")
    PriceModel asPrice(PriceEntity priceEntity);
}
