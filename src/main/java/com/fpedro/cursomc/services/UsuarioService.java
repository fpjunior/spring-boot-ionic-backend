package com.fpedro.cursomc.services;

import java.util.Optional;

import com.fpedro.cursomc.domain.Categoria;
import com.fpedro.cursomc.domain.Usuario;
import com.fpedro.cursomc.repositories.UsuarioRepository;
import com.fpedro.cursomc.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
		
		@Autowired
		private UsuarioRepository repo;
		
		public Usuario buscar(Integer id) {
			Optional<Usuario> obj = repo.findById(id);
			if (obj == null) {
				throw new ObjectNotFoundException("objeto não encontrado! Id: " + id
						+ ", Tipo: " + Categoria.class.getName());
			}
			return obj.orElse(null);		
		}
}
