package com.game.tictaktoe.strategies;

import com.game.tictaktoe.model.Board;
import com.game.tictaktoe.model.Move;

public class DiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean isWinning(Board board, Move move) {
        return false;
    }
}
