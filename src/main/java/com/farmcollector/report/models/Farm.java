package com.farmcollector.report.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "farms")
@Getter @Setter @NoArgsConstructor
public class Farm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long farmId;
	private String farmName;
}
