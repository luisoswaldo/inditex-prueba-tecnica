package com.inditex.prueba.apirest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PriceDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("productId")
    private Integer productId;

    @JsonProperty("brandId")
    private Integer brandId;

    @JsonProperty("productList")
    private Integer priceList;

    @JsonProperty("startDate")
    private String startDate;

    @JsonProperty("endDate")
    private String endDate;

    @JsonProperty("price")
    private Float price;
}
