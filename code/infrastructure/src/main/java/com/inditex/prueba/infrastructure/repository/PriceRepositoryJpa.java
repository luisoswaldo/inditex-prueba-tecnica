package com.inditex.prueba.infrastructure.repository;

import com.inditex.prueba.infrastructure.repository.entity.PriceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface PriceRepositoryJpa extends JpaRepository<PriceEntity, Integer> {
    @Query(value = "SELECT p FROM PriceEntity p WHERE p.startDate <= ?1 and p.endDate >= ?1 and p.productId = ?2 and p.brandEntity.brandId = ?3 ORDER BY p.priority DESC")
    Page<PriceEntity> findPriceByDateAndProductIdAndBrandId(LocalDateTime appDate, Integer productId, Integer brandId, Pageable pageable);

}
