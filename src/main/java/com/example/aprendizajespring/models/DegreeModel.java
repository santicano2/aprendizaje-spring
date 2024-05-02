package com.example.aprendizajespring.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DegreeModel {
	private int id;
	private String name;

	@Size(min = 3, max = 12)
	private String institution;

	@Min(3)
	private int year;

	public DegreeModel(int id, String name, String institution, int year) {
		this.id = id;
		this.name = name;
		this.institution = institution;
		this.year = year;
	}

	public DegreeModel(String name, String institution, int year) {
		this.name = name;
		this.institution = institution;
		this.year = year;
	}

}
