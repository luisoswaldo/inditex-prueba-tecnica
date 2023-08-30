package com.inditex.prueba.infrastructure.repository;

import com.inditex.prueba.infrastructure.repository.h2.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepositoryJpa extends JpaRepository<PriceEntity, Integer> {

    @Query(value = "SELECT brand_id,\n" +
            "       price,\n" +
            "       price_list,\n" +
            "       priority,\n" +
            "       product_id,\n" +
            "       start_date,\n" +
            "       end_date,\n" +
            "       curr\n" +
            "FROM   (SELECT *,\n" +
            "               Row_number()\n" +
            "                 OVER (\n" +
            "                   partition BY p.product_id, p.brand_id\n" +
            "                   ORDER BY p.priority DESC) AS row_number\n" +
            "        FROM   prices p\n" +
            "        WHERE  p.start_date <= ?1\n" +
            "               AND p.end_date >= ?1\n" +
            "               AND p.product_id = ?2\n" +
            "               AND p.brand_id = ?3\n" +
            "        ORDER  BY row_number)\n" +
            "WHERE  row_number = 1", nativeQuery = true)
    Optional<PriceEntity> findPriceByDateAndProductIdAndBrandId(LocalDateTime appDate, Integer productId, Integer brandId);

}
