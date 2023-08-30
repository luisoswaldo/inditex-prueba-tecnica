package com.inditex.prueba.apirest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ApiResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("message")
    private String message;

}
