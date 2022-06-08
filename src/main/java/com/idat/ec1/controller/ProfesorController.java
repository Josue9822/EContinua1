package com.idat.ec1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idat.ec1.model.Profesor;
import com.idat.ec1.service.ProfesorService;

@Controller
@RequestMapping("/profesor/perez")
public class ProfesorController {
	
	@Autowired
	private ProfesorService service;
	
	@RequestMapping("/listar")
	public ResponseEntity<List<Profesor>> listar(){
		return new ResponseEntity<List<Profesor>>(service.listarProfesor(), HttpStatus.OK);
	}

	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Profesor> listarPorId(@PathVariable Integer id){
		Profesor p = service.obtenerProfesor(id);
		
		if (p!=null) {
			return new ResponseEntity<Profesor>(service.obtenerProfesor(id), HttpStatus.OK);
		}
		
		return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Profesor profe){
		service.guardarProfesor(profe);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Profesor profe){
		Profesor p = service.obtenerProfesor(profe.getIdProfesor());
		if (p!=null) {
			service.actualizarProfesor(profe);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Profesor p = service.obtenerProfesor(id);
		if (p!= null) {
			service.eliminarProfesor(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
