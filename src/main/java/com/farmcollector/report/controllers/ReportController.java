package com.farmcollector.report.controllers;

import com.farmcollector.report.dao.SeasonPeriodRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {
	private SeasonPeriodRepository seasonPeriodRepository;

	public ReportController(SeasonPeriodRepository seasonPeriodRepository) {
		this.seasonPeriodRepository = seasonPeriodRepository;
	}

	@GetMapping("/{season}")
	public List<SeasonPeriodRepository.ReportDto> getReportForSeason(@PathVariable("season") String season) {
		return seasonPeriodRepository.findExpectedAndHarvestedDataBySeason(season);
	}

}
