package com.farmcollector.report.dao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ReportDto {
	private Long seasonPeriodId;
	private LocalDate periodStart;
	private LocalDate periodEnd;
	private String farmName;
	private String productName;
	private String season;
	private Double area;
	private LocalDate datePlanted;
	private Double expectedAmount;
	private LocalDate dateHarvested;
	private Double harvestedAmount;
}
