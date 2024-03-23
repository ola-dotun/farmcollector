package com.farmcollector.report.controllers;

import com.farmcollector.report.dao.FarmRepository;
import com.farmcollector.report.models.Farm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/farms")
public class FarmController {

	private final FarmRepository farmRepository;
	public FarmController(FarmRepository farmRepository) {
		this.farmRepository = farmRepository;
	}

	@GetMapping
	public List<Farm> getFarms() {
		return farmRepository.findAll();
	}
}
