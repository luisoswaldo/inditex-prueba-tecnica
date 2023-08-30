package com.inditex.prueba.apirest.mapper;

import com.inditex.prueba.apirest.dto.PriceDTO;
import com.inditex.prueba.domain.model.PriceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceDtoMapper {

    PriceDtoMapper mapper = Mappers.getMapper(PriceDtoMapper.class);

    @Mapping(target = "startDate", dateFormat = "yyyy-MM-dd-HH.mm.ss")
    @Mapping(target = "endDate", dateFormat = "yyyy-MM-dd-HH.mm.ss")
    PriceDTO asPriceDTO(PriceModel priceModel);

}
