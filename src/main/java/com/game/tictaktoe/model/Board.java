package com.game.tictaktoe.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {
    List<List<Cell>> board;
    int N;

    public Board(int N) {
        this.N = N;
        this.board = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            board.add(new ArrayList<>());
            for(int j = 0; j < N; j++) {
                board.get(i).add(new Cell(i,j));
            }
        }
    }

    public void displayBoard() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append("|");
            for(int j = 0; j < N; j++) {
                Cell cell = board.get(i).get(j);
                if(cell.getCellState() == CellState.EMPTY)
                    sb.append(" ");
                else
                    sb.append(cell.getPlayer().getSymbol());
                sb.append(" |");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
