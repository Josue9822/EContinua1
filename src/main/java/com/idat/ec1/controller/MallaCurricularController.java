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

import com.idat.ec1.model.MallaCurricular;
import com.idat.ec1.service.MallaCurricularService;

@Controller
@RequestMapping("/malla/perez")
public class MallaCurricularController {
	
	@Autowired
	private MallaCurricularService service;
	
	@RequestMapping("/listar")
	public ResponseEntity<List<MallaCurricular>> listar(){
		return new ResponseEntity<List<MallaCurricular>>(service.listarMalla(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<MallaCurricular> listarPorId(@PathVariable Integer id){
		MallaCurricular m = service.obtenerMalla(id);
		
		if (m!=null) {
			return new ResponseEntity<MallaCurricular>(service.obtenerMalla(id), HttpStatus.OK);
		}
		
		return new ResponseEntity<MallaCurricular>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody MallaCurricular malla){
		service.guardarMalla(malla);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody MallaCurricular malla){
		MallaCurricular m = service.obtenerMalla(malla.getIdMalla());
		if (m!=null) {
			service.actualizarMalla(malla);;
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		MallaCurricular m = service.obtenerMalla(id);
		if (m!= null) {
			service.eliminarMalla(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
