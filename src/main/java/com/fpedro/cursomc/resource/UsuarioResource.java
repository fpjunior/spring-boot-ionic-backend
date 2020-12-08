package com.fpedro.cursomc.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fpedro.cursomc.domain.Usuario;
import com.fpedro.cursomc.dto.UsuarioDTO;
import com.fpedro.cursomc.services.UsuarioService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
 
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Usuario> find(@PathVariable Integer id) {
			Usuario obj = usuarioService.find(id);
			return ResponseEntity.ok().body(obj);	
				
	}

	public ResponseEntity<Void> update(@RequestBody UsuarioDTO objDto, @PathVariable Integer id){
		Usuario obj = usuarioService.fromDTO(objDto);
		obj.setId(id);
		obj = usuarioService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity <List<Usuario>> findAll() {
		List<Usuario> list = usuarioService.findAll();
		return ResponseEntity.ok().body(list);

	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Usuario obj) {
		obj = usuarioService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
