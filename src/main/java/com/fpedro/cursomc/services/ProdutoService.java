package com.fpedro.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpedro.cursomc.domain.Produto;
import com.fpedro.cursomc.repositories.ProdutoRepository;


@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repo;    
	public Produto find(Integer id) {
        Optional<Produto> obj = repo.findById(id);
        return obj.orElseThrow(() -> new com.fpedro.cursomc.services.exception.ObjectNotFoundException (
                "Objeto não encontrado ! Id: " + id + ", Tipo: " + Produto.class.getName()));
    }
	
	public List<Produto> findAll(){
		return repo.findAll();
	}
}
