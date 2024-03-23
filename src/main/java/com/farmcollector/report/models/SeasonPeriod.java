package com.farmcollector.report.models;

import com.farmcollector.report.dao.dto.ReportDto;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "season_periods")
@Getter
@Setter
@NoArgsConstructor
@NamedNativeQuery(
	name = "expected_and_harvested_products_by_season",
	query = "select " +
			"pp.season_period_id as seasonPeriodId, " +
			"period_start as periodStart, " +
			"period_end as periodEnd, " +
			"farm_name as farmName," +
			"product_name as productName, " +
			"farm_name, " +
			"season, " +
			"area, " +
			"date_planted as datePlanted, " +
			"expected_amount as expectedAmount, " +
			"hp.date_harvested as dateHarvested, " +
			"hp.harvested_amount as harvestedAmount " +
			"FROM SEASON_PERIODS sp " +
			"inner join planted_products pp " +
			"on pp.season_period_id = sp.season_period_id " +
			"inner join harvested_products hp " +
			"on hp.season_period_id = sp.season_period_id " +
			"inner join products p on p.product_id = pp.product_id " +
			"inner join farms f on f.farm_id = pp.farm_id " +
			"where pp.season_period_id = :season_period_id",
	resultSetMapping = "products_by_season"
)
@SqlResultSetMapping(
	name = "products_by_season",
	classes = @ConstructorResult(
		targetClass = ReportDto.class,
		columns = {
			@ColumnResult(name = "seasonPeriodId", type = Long.class),
			@ColumnResult(name = "periodStart", type = LocalDate.class),
			@ColumnResult(name = "periodEnd", type = LocalDate.class),
			@ColumnResult(name = "farmName", type = String.class),
			@ColumnResult(name = "productName", type = String.class),
			@ColumnResult(name = "season", type = String.class),
			@ColumnResult(name = "area", type = Double.class),
			@ColumnResult(name = "datePlanted", type = LocalDate.class),
			@ColumnResult(name = "expectedAmount", type = Double.class),
			@ColumnResult(name = "dateHarvested", type = LocalDate.class),
			@ColumnResult(name = "harvestedAmount", type = Double.class)
		}
	)
)
@AllArgsConstructor
public class SeasonPeriod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seasonPeriodId;

	@Enumerated(EnumType.STRING)
	private Season season;

	private LocalDate periodStart;
	private LocalDate periodEnd;

	public enum Season {
		SPRING,
		SUMMER,
		AUTUMN,
		WINTER
	}
}
