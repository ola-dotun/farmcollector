package com.farmcollector.report.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "planted_products")
@Getter
@Setter
@NoArgsConstructor
public class PlantedProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long plantedId;
	private Double area;
	@ManyToOne
	@JoinColumn(name = "farm_id")
	private Farm farm;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "season_period_id")
	private SeasonPeriod seasonPeriod;
	private LocalDate datePlanted;
	private Double expectedAmount;
}
