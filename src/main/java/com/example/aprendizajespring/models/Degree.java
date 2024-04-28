package com.example.aprendizajespring.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Degree {
	private int id;
	private String name;
	private String institution;
	private int year;

	public Degree() {
	}

	public Degree(int id, String name, String institution, int year) {
		this.id = id;
		this.name = name;
		this.institution = institution;
		this.year = year;
	}

	public Degree(String name, String institution, int year) {
		this.name = name;
		this.institution = institution;
		this.year = year;
	}

}
