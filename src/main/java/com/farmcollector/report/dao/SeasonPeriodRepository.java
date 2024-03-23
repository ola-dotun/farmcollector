package com.farmcollector.report.dao;

import com.farmcollector.report.dao.dto.ReportDto;
import com.farmcollector.report.models.SeasonPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeasonPeriodRepository extends JpaRepository<SeasonPeriod, Long> {

	@Query(
		nativeQuery = true,
		name = "expected_and_harvested_products_by_season"
	)
	List<ReportDto> findExpectedAndHarvestedDataBySeasonPeriod(@Param("season_period_id") Long seasonPeriodId);
}
