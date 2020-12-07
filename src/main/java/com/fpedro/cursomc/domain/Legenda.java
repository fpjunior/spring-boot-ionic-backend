package com.fpedro.cursomc.domain;

public enum Legenda {
    

    AG("AG", "Agendado"),
    EA("ED", "Em Andamento"),
    EF("EF", "Evento Finalizado"),
    EC("EC", "Evento cancelado");


    private String sigla;
    private String descricao;

    Legenda(String sigla, String descricao){
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
