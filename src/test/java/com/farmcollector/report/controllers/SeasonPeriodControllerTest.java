package com.farmcollector.report.controllers;

import com.farmcollector.report.dao.SeasonPeriodRepository;
import com.farmcollector.report.models.SeasonPeriod;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class SeasonPeriodControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private SeasonPeriodRepository seasonPeriodRepository;

	@Test
	void getAllSeasonsShouldReturnSeasonsAvailable() throws Exception {
		when(seasonPeriodRepository.findAll()).thenReturn(
			Lists.list(
				new SeasonPeriod(1L, SeasonPeriod.Season.AUTUMN, LocalDate.now(), LocalDate.now().plusMonths(3))
			)
		);
		mockMvc.perform(get("/seasons"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].season", is("AUTUMN")));
	}
}
