package com.farmcollector.report.controllers;

import com.farmcollector.report.dao.SeasonPeriodRepository;
import com.farmcollector.report.models.SeasonPeriod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seasons")
public class SeasonPeriodController {

	private SeasonPeriodRepository seasonPeriodRepository;

	public SeasonPeriodController(SeasonPeriodRepository seasonPeriodRepository) {
		this.seasonPeriodRepository = seasonPeriodRepository;
	}

	@GetMapping
	public List<SeasonPeriod> getAllSeasons() {
		return this.seasonPeriodRepository.findAll();
	}
}
