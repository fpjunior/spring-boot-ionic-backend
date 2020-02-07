package com.fpedro.cursomc.services;

import java.util.Optional;

import com.fpedro.cursomc.domain.Estado;
import com.fpedro.cursomc.repositories.EstadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {
	@Autowired
	private EstadoRepository repo;    
	public Estado find(Integer id) {
        Optional<Estado> obj = repo.findById(id);
        return obj.orElseThrow(() -> new com.fpedro.cursomc.services.exception.ObjectNotFoundException (
                "Objeto não encontrado ! Id: " + id + ", Tipo: " + Estado.class.getName()));
    }
}