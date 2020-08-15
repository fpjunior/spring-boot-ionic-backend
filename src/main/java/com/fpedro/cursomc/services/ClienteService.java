package com.fpedro.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fpedro.cursomc.domain.Cliente;
import com.fpedro.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {
        @Autowired
        private ClienteRepository repo;

        public Cliente find(Integer id) {
                Optional<Cliente> obj = repo.findById(id);
                return obj.orElseThrow(() -> new com.fpedro.cursomc.services.exception.ObjectNotFoundException(
                                "Objeto não encontrado ! Id: " + id + ", Tipo: " + Cliente.class.getName()));
        }
        
    	public Cliente insert(Cliente obj) {
    		obj.setId(null);
    		return repo.save(obj);
    	}
    	
    	public Cliente update(Cliente obj) {
    		find(obj.getId());
    		return repo.save(obj);
    	}
    	
    	public List<Cliente> findAll(){
    	return repo.findAll();
		}
		
		// public void delete(Integer id){
		// 	find(id);
		// 	try {
		// 		repo.delete(id);
		// 	} catch (DataIntegrityViolationException e) {
		// 		throw new DataIntegrityViolationException("Não é possível excluir uma categoria que possui produtos");
		// 	}
		// }
		
}
