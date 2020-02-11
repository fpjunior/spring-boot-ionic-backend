package com.fpedro.cursomc.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fpedro.cursomc.domain.Estado;
import com.fpedro.cursomc.services.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {

	@Autowired
	private EstadoService service;
 
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Estado> find(@PathVariable Integer id) {
			Estado obj = service.find(id);
			return ResponseEntity.ok().body(obj);		
			
	}
	
	@RequestMapping( method=RequestMethod.GET)
	public ResponseEntity<List<Estado>> findAll() {
			List<Estado> list = service.findAll();
			return ResponseEntity.ok().body(list);
}
}