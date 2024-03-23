package com.farmcollector.report.controllers;

import com.farmcollector.report.dao.SeasonPeriodRepository;
import com.farmcollector.report.dao.dto.ReportDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {
	private final SeasonPeriodRepository seasonPeriodRepository;

	public ReportController(SeasonPeriodRepository seasonPeriodRepository) {
		this.seasonPeriodRepository = seasonPeriodRepository;
	}

	@GetMapping("/{season-period-id}")
	public @ResponseBody List<ReportDto> getReportForSeason(@PathVariable("season-period-id") Long seasonPeriodId) {
		return seasonPeriodRepository.findExpectedAndHarvestedDataBySeasonPeriod(seasonPeriodId);
	}
}
