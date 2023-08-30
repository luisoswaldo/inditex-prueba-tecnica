package com.inditex.prueba.apirest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.prueba.apirest.dto.PriceRequestDTO;
import com.inditex.prueba.domain.model.PriceModel;
import com.inditex.prueba.domain.usecase.GetPricesUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {PriceController.class})
@ExtendWith(SpringExtension.class)
class PriceControllerTest {
    @MockBean
    private GetPricesUseCase getPricesUseCase;

    @Autowired
    private PriceController priceController;

    private ObjectMapper objectMapper;

    @BeforeEach()
    public void setup()
    {
        this.objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
    }

    @Test
    void testGetPrice1() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.get("/v1/price")
                .contentType(MediaType.APPLICATION_JSON);

        PriceRequestDTO priceRequestDTO = new PriceRequestDTO();
        priceRequestDTO.setAppDate(LocalDateTime.now());
        priceRequestDTO.setProductId(1);
        priceRequestDTO.setBrandId(1);

        PriceModel priceModel = new PriceModel();
        priceModel.setBrandId(1);
        priceModel.setEndDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        priceModel.setPrice(10.0f);
        priceModel.setPriceList(1);
        priceModel.setProductId(1);
        priceModel.setStartDate(LocalDate.of(1970, 1, 1).atStartOfDay());


        when(getPricesUseCase.findPrice(Mockito.any(), Mockito.any(), Mockito.any()))
                .thenReturn(priceModel);

        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(priceRequestDTO));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(priceController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productList").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").isNotEmpty());
    }

    @Test
    void testGetPrice2() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.get("/v1/price")
                .contentType(MediaType.APPLICATION_JSON);


        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new PriceRequestDTO()));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(priceController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

}

