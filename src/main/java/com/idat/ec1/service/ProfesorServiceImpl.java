package com.idat.ec1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec1.model.Profesor;
import com.idat.ec1.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService {
	
	@Autowired
	ProfesorRepository repo;

	@Override
	public void guardarProfesor(Profesor profesor) {
		repo.save(profesor);
	}

	@Override
	public void actualizarProfesor(Profesor profesor) {
		repo.saveAndFlush(profesor);

	}

	@Override
	public void eliminarProfesor(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public Profesor obtenerProfesor(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Profesor> listarProfesor() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
