package com.farmcollector.report.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "season_periods")
@Getter
@Setter
@NoArgsConstructor
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
