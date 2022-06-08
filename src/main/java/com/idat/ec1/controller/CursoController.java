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

import com.idat.ec1.model.Curso;
import com.idat.ec1.service.CursoService;

@Controller
@RequestMapping("/curso/perez")
public class CursoController {
	
	@Autowired
	private CursoService service;
	
	@RequestMapping("/listar")
	public ResponseEntity<List<Curso>> listar(){
		return new ResponseEntity<List<Curso>>(service.listaCurso(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Curso> listarPorId(@PathVariable Integer id){
		Curso c = service.obtenerCurso(id);
		
		if (c!=null) {
			return new ResponseEntity<Curso>(service.obtenerCurso(id), HttpStatus.OK);
		}
		
		return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Curso curso){
		service.guardarCurso(curso);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Curso curso){
		Curso c = service.obtenerCurso(curso.getIdCurso());
		if (c!=null) {
			service.actualizarCurso(curso);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Curso c = service.obtenerCurso(id);
		if (c!= null) {
			service.eliminarCurso(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
