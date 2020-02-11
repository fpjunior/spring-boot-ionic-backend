package com.fpedro.cursomc.services;

import java.util.Optional;

import com.fpedro.cursomc.domain.Solicitacao;
import com.fpedro.cursomc.repositories.SolicitacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitacaoService {
	@Autowired
	private SolicitacaoRepository repo;

	public Solicitacao find(Integer id) {
		Optional<Solicitacao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new com.fpedro.cursomc.services.exception.ObjectNotFoundException(
				"Objeto não encontrado ! Id: " + id + ", Tipo: " + Solicitacao.class.getName()));
	}
}
