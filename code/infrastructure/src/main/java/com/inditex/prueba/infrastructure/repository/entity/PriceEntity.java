package com.inditex.prueba.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "PRICES")
@Getter
@Setter
public class PriceEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BRAND_ID", referencedColumnName = "BRAND_ID")
    private BrandEntity brandEntity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Id
    @Column(name = "PRICE_LIST")
    private Integer priceList;

    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "PRICE")
    private Float price;

    @Column(name = "CURR")
    private String curr;

}
