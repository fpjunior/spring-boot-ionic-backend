package com.fpedro.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpedro.cursomc.domain.Usuario;
import com.fpedro.cursomc.repositories.UsuarioRepository;


@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repo;    
	public Usuario find(Integer id) {
        Optional<Usuario> obj = repo.findById(id);
        return obj.orElseThrow(() -> new com.fpedro.cursomc.services.exception.ObjectNotFoundException (
                "Objeto não encontrado ! Id: " + id + ", Tipo: " + Usuario.class.getName()));
    }
	
	public List<Usuario> findAll(){
		return repo.findAll();
	}
}
