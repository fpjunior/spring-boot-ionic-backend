package com.fpedro.cursomc.resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fpedro.cursomc.domain.Solicitacao;
import com.fpedro.cursomc.services.SolicitacaoService;

@RestController
@RequestMapping(value="/solicitacoes")
public class SolicitacaoResource {
	
	@Autowired
	private SolicitacaoService service;
 
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Solicitacao> find(@PathVariable Integer id) {
			Solicitacao obj = service.find(id);
			return ResponseEntity.ok().body(obj);		
			
	}
}
