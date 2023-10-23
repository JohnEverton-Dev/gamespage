package com.alvestech.gamespage.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_game_list")
public class ListaJogos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public ListaJogos(){}
    public ListaJogos(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListaJogos listaJogos)) return false;

        return getId().equals(listaJogos.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}