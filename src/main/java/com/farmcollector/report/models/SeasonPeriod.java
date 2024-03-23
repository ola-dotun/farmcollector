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
	query = """
		SELECT planted.season_period_id AS seasonPeriodId,
         planted.period_start AS periodStart,
         planted.period_end AS periodEnd,
         planted.farm_name AS farmName,
         planted.product_name AS productName,
         planted.season,
         planted.area,
         planted.date_planted AS datePlanted,
         planted.expected_amount AS expectedAmount,
         harvested.date_harvested AS dateHarvested,
         harvested.harvested_amount AS harvestedAmount
  FROM
      (SELECT sp.season_period_id,
              period_start,
              period_end,
              farm_name,
              product_name,
              season,
              area,
              date_planted,
              expected_amount
       FROM season_periods sp
                INNER JOIN planted_products pp ON pp.season_period_id = sp.season_period_id
                INNER JOIN products p ON p.product_id = pp.product_id
                INNER JOIN farms f ON f.farm_id = pp.farm_id
       WHERE pp.season_period_id = :season_period_id) planted
          INNER JOIN
      (SELECT sp.season_period_id,
              period_start,
              period_end,
              farm_name,
              product_name,
              season,
              date_harvested,
              harvested_amount
       FROM season_periods sp
                INNER JOIN harvested_products hp ON hp.season_period_id = sp.season_period_id
                INNER JOIN products p ON p.product_id = hp.product_id
                INNER JOIN farms f ON f.farm_id = hp.farm_id
       WHERE hp.season_period_id = :season_period_id) harvested ON planted.season_period_id = harvested.season_period_id
          AND planted.farm_name = harvested.farm_name
          AND planted.product_name = harvested.product_name
			""",
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
