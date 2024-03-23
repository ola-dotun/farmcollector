package com.farmcollector.report.dao;

import com.farmcollector.report.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
