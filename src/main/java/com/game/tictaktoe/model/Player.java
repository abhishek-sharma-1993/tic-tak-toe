package com.game.tictaktoe.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Player {
    private String name;
    private Symbol symbol;
    private int id;

    public Player(String name, int id, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
        this.id = id;
    }

    public abstract Move makeMove(Board board);
}
