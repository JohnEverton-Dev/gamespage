package com.alvestech.gamespage.dto;

import com.alvestech.gamespage.entities.ListaJogos;

public class ListaJogosDTO {
    private Long id;
    private String name;

    public ListaJogosDTO(){}

    public ListaJogosDTO(ListaJogos entity){
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {return id;}
    public String getName() {return name;}
}