package com.idat.ec1.service;

import java.util.List;

import com.idat.ec1.model.Profesor;

public interface ProfesorService {
	void guardarProfesor(Profesor profesor);
	void actualizarProfesor(Profesor profesor);
	void eliminarProfesor(Integer id);
	Profesor obtenerProfesor(Integer id);
	List<Profesor> listarProfesor();

}
