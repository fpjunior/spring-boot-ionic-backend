package com.fpedro.cursomc.domain;

import java.io.Serializable;

import com.fpedro.cursomc.enums.EstadoPagamento;

/**
 * Pagamento
 */
public class Pagamento implements Serializable {
private static final long serialVersionUID = 1L;

    private Integer id;
    private EstadoPagamento estado;

    private Solicitacao solicitacao;

    public Pagamento(){
    }

    

    public Pagamento(Integer id, EstadoPagamento estado, Solicitacao solicitacao) {
        this.id = id;
        this.estado = estado;
        this.solicitacao = solicitacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoPagamento getEstado() {
        return estado;
    }

    public void setEstado(EstadoPagamento estado) {
        this.estado = estado;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pagamento other = (Pagamento) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    
}