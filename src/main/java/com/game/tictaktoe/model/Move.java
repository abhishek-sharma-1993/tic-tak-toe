package com.game.tictaktoe.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Move {
    private Cell cell;
    public Move(int row,int col) {
        this.cell = new Cell(row, col);
    }
}
