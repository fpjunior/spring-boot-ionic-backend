package com.fpedro.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpedro.cursomc.domain.Estado;
import com.fpedro.cursomc.repositories.EstadoRepository;

@Service
public class EstadoService {
	@Autowired
	private EstadoRepository repo;    
	public Estado find(Integer id) {
        Optional<Estado> obj = repo.findById(id);
        return obj.orElseThrow(() -> new com.fpedro.cursomc.services.exception.ObjectNotFoundException (
                "Objeto não encontrado ! Id: " + id + ", Tipo: " + Estado.class.getName()));
    }
	
	public List<Estado> findAll(){
		return repo.findAll();
	}
}