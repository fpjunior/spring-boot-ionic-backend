package com.fpedro.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fpedro.cursomc.domain.Categoria;
import com.fpedro.cursomc.domain.Cliente;
import com.fpedro.cursomc.dto.CategoriaDTO;
import com.fpedro.cursomc.dto.ClienteDTO;
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
    	
		public void delete(Integer id) {
			find(id);
			try {
				repo.deleteById(id);
			} catch (DataIntegrityViolationException e) {
				throw new DataIntegrityViolationException("não é possível excluir uma categoria que possui Produtos");
	
			}
		}
	
		public List<Cliente> findAll() {
			return repo.findAll();
		}
		
		public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
			PageRequest pageRequest =  PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
			return repo.findAll(pageRequest);
		}
	
		public Cliente fromDTO(ClienteDTO objDto){
			return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
		}
		
}
