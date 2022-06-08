package com.idat.ec1.service;

import java.util.List;

import com.idat.ec1.model.MallaCurricular;

public interface MallaCurricularService {
	
	void guardarMalla(MallaCurricular malla);
	void actualizarMalla(MallaCurricular malla);
	void eliminarMalla(Integer id);
	MallaCurricular obtenerMalla(Integer id);
	List<MallaCurricular> listarMalla();

}
