package com.inditex.prueba.apirest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PriceRequestDTO {
    @NotNull(message = "Application date cannot be blank")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'-'HH.mm.ss")
    private LocalDateTime appDate;

    @NotNull(message = "Product Identifier cannot be blank")
    private Integer productId;

    @NotNull(message = "Brand Identifier cannot be blank")
    private Integer brandId;
}
