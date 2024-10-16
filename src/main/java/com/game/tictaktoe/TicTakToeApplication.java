package com.game.tictaktoe;

import com.game.tictaktoe.controller.GameController;
import com.game.tictaktoe.model.*;
import com.game.tictaktoe.strategies.ColWinningStrategy;
import com.game.tictaktoe.strategies.RowWinningStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TicTakToeApplication {

    public static void main(String[] args) {

//        SpringApplication.run(TicTakToeApplication.class, args);

        GameController gameController = new GameController();

        Player player1 = new HumanPlayer("Abhishek", 1, Symbol.X);
        Player player2 = new HumanPlayer("Shubhi", 2, Symbol.O);

        Game game = gameController.startGame(
                3,
                List.of(player1,player2),
                List.of(new ColWinningStrategy(), new RowWinningStrategy())
        );

        game.getBoard().displayBoard();

        while(gameController.getGameState(game) == GameState.START ){
            gameController.makeNextMove(game);
            gameController.displayBoard(game.getBoard());
        }

        game.getBoard().displayBoard();
        if(gameController.getGameState(game) == GameState.DRAW){
            System.out.println("Game ended in a draw");
        }else{
            System.out.printf("The winner is %s", game.getWinner().getName());
        }
    }

}
