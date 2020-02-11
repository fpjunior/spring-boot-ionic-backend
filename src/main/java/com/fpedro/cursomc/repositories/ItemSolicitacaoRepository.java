package com.fpedro.cursomc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpedro.cursomc.domain.ItemSolicitacao;

@Repository
public interface ItemSolicitacaoRepository extends JpaRepository<ItemSolicitacao, Integer> {


}
