package com.fpedro.cursomc.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fpedro.cursomc.domain.Endereco;
import com.fpedro.cursomc.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {

	@Autowired
	private EnderecoService service;
 
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Endereco> find(@PathVariable Integer id) {
			Endereco obj = service.find(id);
			return ResponseEntity.ok().body(obj);		
			
	}
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity <List<Endereco>> findAll() {
			List<Endereco> list = service.findAll();
			return ResponseEntity.ok().body(list);
}
	
}
