package com.game.tictaktoe.strategies;

import com.game.tictaktoe.model.Board;
import com.game.tictaktoe.model.Cell;
import com.game.tictaktoe.model.CellState;
import com.game.tictaktoe.model.Move;

public class ColWinningStrategy implements WinningStrategy{
    @Override
    public boolean isWinning(Board board, Move move) {
        Cell cell = move.getCell();
        for (int row=0; row< board.getN(); row++){
            if(board.getBoard().get(row).get(cell.getCol()).getCellState() == CellState.EMPTY ||
                    board.getBoard().get(row).get(cell.getCol()).getPlayer() != cell.getPlayer() ){
                return false;
            }
        }
        return true;
    }
}
