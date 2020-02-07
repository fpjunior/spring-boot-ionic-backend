package com.fpedro.cursomc.services;

import java.util.Optional;

import com.fpedro.cursomc.domain.Endereco;
import com.fpedro.cursomc.repositories.EnderecoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repo;

    public Endereco find(Integer id) {
        Optional<Endereco> obj = repo.findById(id);
        return obj.orElseThrow(() -> new com.fpedro.cursomc.services.exception.ObjectNotFoundException(
                "Objeto não encontrado ! Id: " + id + ", Tipo: " + Endereco.class.getName()));
    }
}