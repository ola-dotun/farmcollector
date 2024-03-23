package com.farmcollector.report.controllers;

import com.farmcollector.report.dao.SeasonPeriodRepository;
import com.farmcollector.report.dao.dto.ReportDto;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class ReportControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SeasonPeriodRepository seasonPeriodRepository;

	@Test
	void getReportForSeasonShouldReturnReportData() throws Exception {
		when(seasonPeriodRepository.findExpectedAndHarvestedDataBySeasonPeriod(any())).thenReturn(
			Lists.list(
				new ReportDto(1L, LocalDate.now(), LocalDate.now(), "Farm A", "Corn", "WINTER", 100.0, LocalDate.now(), 200.0, LocalDate.now(), 230.0),
				new ReportDto(1L, LocalDate.now(), LocalDate.now(), "Farm B", "Potato", "WINTER", 200.0, LocalDate.now(), 200.0, LocalDate.now(), 230.0)
			)
		);
		mockMvc.perform(get("/reports/1"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].seasonPeriodId", is(1)))
			.andExpect(jsonPath("$[0].productName", is("Corn")))
			.andExpect(jsonPath("$[0].season", is("WINTER")))
			.andExpect(jsonPath("$[0].area", is(100.0)))
			.andExpect(jsonPath("$[0].expectedAmount", is(200.0)))
			.andExpect(jsonPath("$[0].harvestedAmount", is(230.0)));
	}
}
