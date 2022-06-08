package com.idat.ec1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec1.model.Universidad;
import com.idat.ec1.repository.UniversidadRepository;

@Service
public class UniversidadServiceImpl implements UniversidadService {
	
	@Autowired
	UniversidadRepository repo;

	@Override
	public void guardarUni(Universidad uni) {
		repo.save(uni);

	}

	@Override
	public void actualizarUni(Universidad uni) {
		repo.saveAndFlush(uni);

	}

	@Override
	public void eliminarUni(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public Universidad obtenerUni(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Universidad> listarUni() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
