package com.game.tictaktoe.strategies;

import com.game.tictaktoe.model.Board;
import com.game.tictaktoe.model.Cell;
import com.game.tictaktoe.model.CellState;
import com.game.tictaktoe.model.Move;

public class DiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean isWinning(Board board, Move move) {
        Cell cell = move.getCell();
        int row = cell.getRow();
        int col = cell.getCol();

        if(row == col){
            int count = 0;
            for(int i=0; i<board.getN(); i++){
                Cell currCell = board.getBoard().get(i).get(i);
                if(currCell.getCellState() == CellState.FILLED
                        && currCell.getPlayer() == cell.getPlayer()){
                    count++;
                }
            }
            if(count == board.getN()){return true;}
        }

        if(row == board.getN() - 1 - col){
            int count = 0;
            for(int i=0; i<board.getN(); i++){
                Cell currCell = board.getBoard().get(i).get(board.getBoard().size() - 1 - i);
                if(currCell.getCellState() == CellState.FILLED
                    && currCell.getPlayer() == cell.getPlayer()){
                    count++;
                }
            }
            return count == board.getN();
        }

        return false;
    }
}
