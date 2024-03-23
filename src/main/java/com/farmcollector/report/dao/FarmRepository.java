package com.farmcollector.report.dao;

import com.farmcollector.report.models.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRepository extends JpaRepository<Farm, Long> {
}
