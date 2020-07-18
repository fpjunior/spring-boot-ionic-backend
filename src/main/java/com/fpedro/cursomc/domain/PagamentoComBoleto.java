package com.fpedro.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fpedro.cursomc.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {
    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern = "dd/MM/yy")
    private Date dataPagamento;
    
    @JsonFormat(pattern = "dd/MM/yy")
    private Date dataVencimento;

    public PagamentoComBoleto(){

    }

    public PagamentoComBoleto(Integer id, EstadoPagamento estado, Solicitacao solicitacao, Date dataVencimento, Date dataPagamento){
        super(id, estado, solicitacao);
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
        
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    
    
}