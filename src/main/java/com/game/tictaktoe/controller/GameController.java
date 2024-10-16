package com.game.tictaktoe.controller;

import com.game.tictaktoe.exceptions.InvalidMoveException;
import com.game.tictaktoe.model.*;
import com.game.tictaktoe.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> strategies) {
        Board board = new Board(dimension);
        return Game.builder()
                .withGameState(GameState.START)
                .withPlayers(players)
                .withBoard(board)
                .withNextPlayerIndex(0)
                .withMoves(new ArrayList<>())
                .newGame();
    }
    public void displayBoard(Board board) {
        board.displayBoard();
    }

    public GameState getGameState(Game game) {
        return game.getGameState();
    }

    public void makeNextMove(Game game) {
        Player player = game.getPlayers().get(game.getNextPlayerIndex());
        System.out.printf("It's %s move\n",player.getName());

        Move move = player.makeMove(game.getBoard());
        move.getCell().setCellState(CellState.FILLED);
        move.getCell().setPlayer(player);

        try{
            validateMove(move, game.getBoard());
        }catch ( InvalidMoveException e ) {
            System.out.println(e.getMessage());
        }

        updateBoard(game, move, player);
        checkWinningStrategy(game, move, player);

        game.getMoves().add(move);
        game.setNextPlayerIndex( (game.getNextPlayerIndex() + 1) % game.getPlayers().size() );
        checkIfBoardIsFull(game);

    }

    private void checkWinningStrategy(Game game, Move move, Player player) {
        for(WinningStrategy winningStrategy: game.getWinningStrategies()) {
            if(winningStrategy.isWinning(game.getBoard(), move)){
                game.setWinner(player);
                game.setGameState(GameState.FINISHED);
            }
        }
    }

    private void updateBoard(Game game, Move move, Player player) {
        Board board = game.getBoard();
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cell = board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(player);
    }

    private void checkIfBoardIsFull(Game game) {
        Board board = game.getBoard();
        if(game.getMoves().size() == board.getN() * board.getN() && game.getGameState() != GameState.FINISHED) {
            game.setGameState(GameState.DRAW);
        }
    }

    private void validateMove(Move move, Board board) throws InvalidMoveException {
        Cell cell = move.getCell();
        if(cell.getRow()<0 || cell.getRow()>= board.getN() || cell.getCol()<0 || cell.getCol()>=board.getN())
            throw new InvalidMoveException("Invalid move");
    }
}
