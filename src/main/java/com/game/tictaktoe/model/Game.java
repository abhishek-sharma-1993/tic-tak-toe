package com.game.tictaktoe.model;

import com.game.tictaktoe.strategies.ColWinningStrategy;
import com.game.tictaktoe.strategies.RowWinningStrategy;
import com.game.tictaktoe.strategies.WinningStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class Game {
    private Board board;
    private List<Player> players;
    private int nextPlayerIndex;
    private List<Move> moves;
    private GameState gameState;
    private List<WinningStrategy> winningStrategies;
    private Player winner;

    private Game(GameBuilder gameBuilder){
        this.board = gameBuilder.board;
        this.players = gameBuilder.players;
        this.nextPlayerIndex = gameBuilder.nextPlayerIndex;
        this.moves = gameBuilder.moves;
        this.gameState = gameBuilder.gameState;
        this.winningStrategies = gameBuilder.winningStrategies;
        this.winner = gameBuilder.winner;
    }
    public static GameBuilder builder(){
        return new GameBuilder();
    }

    public static class GameBuilder {
        private Board board;
        private List<Player> players;
        private int nextPlayerIndex;
        private List<Move> moves;
        private GameState gameState;
        private List<WinningStrategy> winningStrategies = List.of(new RowWinningStrategy(), new ColWinningStrategy());
        private Player winner;

        public GameBuilder withBoard(Board board) {
            this.board = board;
            return this;
        }
        public GameBuilder withPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        public GameBuilder withNextPlayerIndex(int nextPlayerIndex) {
            this.nextPlayerIndex = nextPlayerIndex;
            return this;
        }
        public GameBuilder withMoves(List<Move> moves) {
            this.moves = moves;
            return this;
        }
        public GameBuilder withGameState(GameState gameState) {
            this.gameState = gameState;
            return this;
        }
        public GameBuilder withGameStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
        public GameBuilder withWinner(Player winner) {
            this.winner = winner;
            return this;
        }
        public Game newGame(){
            return new Game(this);
        }
    }
}
