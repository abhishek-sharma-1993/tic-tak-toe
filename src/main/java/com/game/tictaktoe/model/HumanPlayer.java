package com.game.tictaktoe.model;

import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, int id, Symbol symbol) {
        super(name, id, symbol);
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println("Please enter a valid move");
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new Move(row, col);
    }
}
