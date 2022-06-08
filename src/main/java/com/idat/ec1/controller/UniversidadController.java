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

import com.idat.ec1.model.Universidad;
import com.idat.ec1.service.UniversidadService;

@Controller
@RequestMapping("/universidad/perez")
public class UniversidadController {
	
	@Autowired
	private UniversidadService service;
	
	@RequestMapping("/listar")
	public ResponseEntity<List<Universidad>> listar(){
		return new ResponseEntity<List<Universidad>>(service.listarUni(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Universidad> listarPorId(@PathVariable Integer id){
		Universidad u = service.obtenerUni(id);
		
		if (u!=null) {
			return new ResponseEntity<Universidad>(service.obtenerUni(id), HttpStatus.OK);
		}
		
		return new ResponseEntity<Universidad>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Universidad uni){
		service.guardarUni(uni);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Universidad uni){
		Universidad u = service.obtenerUni(uni.getIdUniversidad());
		if (u!=null) {
			service.actualizarUni(uni);;
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Universidad u = service.obtenerUni(id);
		if (u!= null) {
			service.eliminarUni(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
