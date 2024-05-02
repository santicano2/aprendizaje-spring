package com.example.aprendizajespring.services;

import java.util.List;

import com.example.aprendizajespring.entities.Degree;
import com.example.aprendizajespring.models.DegreeModel;

public interface IDegreeService {
	public List<Degree> getAll();

	public DegreeModel insertOrUpdate(DegreeModel degreeModel);

	public boolean remove(int id);
}
