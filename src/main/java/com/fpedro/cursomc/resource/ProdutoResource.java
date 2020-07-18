package com.fpedro.cursomc.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fpedro.cursomc.domain.Produto;
import com.fpedro.cursomc.services.ProdutoService;

@RestController
@RequestMapping(value="/Produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
 
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Produto> find(@PathVariable final Integer id) {
		final Produto obj = service.find(id);
			return ResponseEntity.ok().body(obj);		
			
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity <List<Produto>> findAll() {
		List<Produto> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}
}
