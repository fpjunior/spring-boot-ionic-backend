package com.fpedro.cursomc.domain;

public class Namorada implements ChegadaAniversarianteObserver {

    @Override
    public void chegou(ChegadaAniversarianteEvent event){
        System.out.println("Apagar as luzes..."); //complemento
        System.out.println("Fazer silêncio");
        System.out.println("Surpresa");

    }
    
}