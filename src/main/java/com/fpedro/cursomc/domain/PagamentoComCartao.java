package com.fpedro.cursomc.domain;

import javax.persistence.Entity;

import com.fpedro.cursomc.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
    private static final long serialVersionUID = 1L;

    private Integer numeroDeParcelas;

    public PagamentoComCartao() {

    }

    public PagamentoComCartao(Integer id, EstadoPagamento quitado, Solicitacao solicitacao, Integer numeroDeParcelas) {
        super(id, quitado, solicitacao);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
    
    
}