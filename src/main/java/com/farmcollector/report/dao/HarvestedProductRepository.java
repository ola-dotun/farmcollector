package com.farmcollector.report.dao;

import com.farmcollector.report.models.HarvestedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HarvestedProductRepository extends JpaRepository<HarvestedProduct, Long> {
}
