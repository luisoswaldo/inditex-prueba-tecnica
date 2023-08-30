package com.inditex.prueba.apirest.controller;

import com.inditex.prueba.apirest.dto.PriceDTO;
import com.inditex.prueba.apirest.dto.PriceRequestDTO;
import com.inditex.prueba.domain.model.PriceModel;
import com.inditex.prueba.domain.usecase.GetPricesUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.inditex.prueba.apirest.mapper.PriceDtoMapper.mapper;

@RestController
@Validated
public class PriceController {

    @Autowired
    GetPricesUseCase getPricesUseCase;

    @GetMapping(
            value = {"/v1/price"},
            produces = {"application/json"}
    )
    public ResponseEntity<PriceDTO> getPrice2(@Valid @RequestBody PriceRequestDTO priceRequest) {
        PriceModel response = this.getPricesUseCase.findPrice(priceRequest.getAppDate(),
                priceRequest.getProductId(),
                priceRequest.getBrandId());
        return new ResponseEntity<>(mapper.asPriceDTO(response), HttpStatus.OK);

    }




}
