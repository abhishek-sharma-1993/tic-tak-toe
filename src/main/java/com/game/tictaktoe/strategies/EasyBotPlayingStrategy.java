package com.game.tictaktoe.strategies;

import com.game.tictaktoe.model.Board;
import com.game.tictaktoe.model.Cell;
import com.game.tictaktoe.model.CellState;
import com.game.tictaktoe.model.Move;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move suggestMove(Board board) {
        for(int row=0; row<board.getN(); row++){
            for(int col=0; col<board.getN(); col++){
                Cell cell = board.getBoard().get(row).get(col);
                if(cell.getCellState() == CellState.EMPTY){
                    return new Move(row,col);
                }
            }
        }
        return null;
    }
}
