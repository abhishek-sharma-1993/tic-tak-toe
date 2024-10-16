package com.game.tictaktoe.strategies;

import com.game.tictaktoe.model.Board;
import com.game.tictaktoe.model.Cell;
import com.game.tictaktoe.model.CellState;
import com.game.tictaktoe.model.Move;

public class RowWinningStrategy implements WinningStrategy {
    @Override
    public boolean isWinning(Board board, Move lastMove) {
        Cell cell = lastMove.getCell();
        for (int col=0; col< board.getN(); col++){
            if(board.getBoard().get(cell.getRow()).get(col).getCellState() == CellState.EMPTY ||
                board.getBoard().get(cell.getRow()).get(col).getPlayer() != cell.getPlayer() ){
                return false;
            }
        }
        return true;
    }
}
