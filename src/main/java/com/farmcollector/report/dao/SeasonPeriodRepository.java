package com.farmcollector.report.dao;

import com.farmcollector.report.models.SeasonPeriod;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SeasonPeriodRepository extends JpaRepository<SeasonPeriod, Long> {

	@Query(
		nativeQuery = true,
		value = "select pp.season_period_id, period_start, period_end, product_name, season, area, date_planted, expected_amount, hp.date_harvested, hp.harvested_amount FROM SEASON_PERIODS sp inner join planted_products pp on pp.season_period_id = sp.season_period_id inner join harvested_products hp on hp.season_period_id = sp.season_period_id inner join products p on p.product_id = pp.product_id where season = :season"
	)
	List<ReportDto> findExpectedAndHarvestedDataBySeason(@Param("season") String season);

	@Data
	class ReportDto {
		Long seasonPeriodId;
		LocalDate periodStart;
		LocalDate periodEnd;
		String productName;
		String season;
		Double area;
		LocalDate datePlanted;
		Double expectedAmount;
		LocalDate dateHarvested;
		Double harvestedAmount;
	}
}
