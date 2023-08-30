package com.inditex.prueba.infrastructure.repository.h2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "BRAND")
@Getter
@Setter
public class BrandEntity {

    @Id
    @Column(name = "BRAND_ID")
    private Integer brandId;

    @Column(name = "name")
    private String name;

}
