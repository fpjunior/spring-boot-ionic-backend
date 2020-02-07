package com.fpedro.cursomc.services;

import java.util.Optional;

import com.fpedro.cursomc.domain.Cliente;
import com.fpedro.cursomc.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
        @Autowired
        private ClienteRepository repo;

        public Cliente find(Integer id) {
                Optional<Cliente> obj = repo.findById(id);
                return obj.orElseThrow(() -> new com.fpedro.cursomc.services.exception.ObjectNotFoundException(
                                "Objeto não encontrado ! Id: " + id + ", Tipo: " + Cliente.class.getName()));
        }
}
