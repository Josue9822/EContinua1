package com.idat.ec1.service;

import java.util.List;

import com.idat.ec1.model.Universidad;

public interface UniversidadService {
	
	void guardarUni(Universidad uni);
	void actualizarUni(Universidad uni);
	void eliminarUni(Integer id);
	Universidad obtenerUni(Integer id);
	List<Universidad> listarUni();

}
