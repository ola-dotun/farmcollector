package com.farmcollector.report.dao;

import com.farmcollector.report.models.PlantedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantedProductRepository extends JpaRepository<PlantedProduct, Long> {
}
