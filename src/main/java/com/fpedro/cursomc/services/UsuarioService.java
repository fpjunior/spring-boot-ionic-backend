package com.fpedro.cursomc.services;

import java.util.Optional;

import com.fpedro.cursomc.domain.Usuario;
import com.fpedro.cursomc.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repo;    
	public Usuario find(Integer id) {
        Optional<Usuario> obj = repo.findById(id);
        return obj.orElseThrow(() -> new com.fpedro.cursomc.services.exception.ObjectNotFoundException (
                "Objeto não encontrado ! Id: " + id + ", Tipo: " + Usuario.class.getName()));
    }
}
