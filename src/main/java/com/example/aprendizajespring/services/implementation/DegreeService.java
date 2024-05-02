package com.example.aprendizajespring.services.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.aprendizajespring.entities.Degree;
import com.example.aprendizajespring.models.DegreeModel;
import com.example.aprendizajespring.repositories.IDegreeRepository;
import com.example.aprendizajespring.services.IDegreeService;

@Service("degreeService")
public class DegreeService implements IDegreeService {

	private IDegreeRepository degreeRepository;

	private ModelMapper modelMapper = new ModelMapper();

	public DegreeService(IDegreeRepository degreeRepository) {
		this.degreeRepository = degreeRepository;
	}

	@Override
	public List<Degree> getAll() {
		return degreeRepository.findAll();
	}

	@Override
	public DegreeModel insertOrUpdate(DegreeModel degreeModel) {
		Degree degree = degreeRepository.save(modelMapper.map(degreeModel, Degree.class));
		return modelMapper.map(degree, DegreeModel.class);
	}

	@Override
	public boolean remove(int id) {
		try {
			degreeRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
