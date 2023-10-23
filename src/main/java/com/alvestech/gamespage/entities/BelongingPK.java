package com.alvestech.gamespage.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class BelongingPK {
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private ListaJogos list;

    public BelongingPK(Game game, ListaJogos list) {
        this.game = game;
        this.list = list;
    }
    public BelongingPK(){}

    public Game getGame() {return game;}
    public void setGame(Game game) {this.game = game;}
    public ListaJogos getList() {return list;}
    public void setList(ListaJogos list) {this.list = list;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BelongingPK that)) return false;
        if (!getGame().equals(that.getGame())) return false;
        return getList().equals(that.getList());
    }

    @Override
    public int hashCode() {
        int result = getGame().hashCode();
        result = 31 * result + getList().hashCode();
        return result;
    }
}