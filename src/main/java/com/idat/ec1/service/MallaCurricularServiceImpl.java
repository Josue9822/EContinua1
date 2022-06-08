package com.idat.ec1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec1.model.MallaCurricular;
import com.idat.ec1.repository.MallaCurricularRepository;
@Service
public class MallaCurricularServiceImpl implements MallaCurricularService {

	@Autowired
	MallaCurricularRepository repo;
	
	@Override
	public void guardarMalla(MallaCurricular malla) {
		repo.save(malla);

	}

	@Override
	public void actualizarMalla(MallaCurricular malla) {
		repo.saveAndFlush(malla);

	}

	@Override
	public void eliminarMalla(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public MallaCurricular obtenerMalla(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<MallaCurricular> listarMalla() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
