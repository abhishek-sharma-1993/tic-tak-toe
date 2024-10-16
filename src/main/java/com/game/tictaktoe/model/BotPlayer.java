package com.game.tictaktoe.model;

import com.game.tictaktoe.strategies.BotPlayingStrategy;

public class BotPlayer extends Player{
    BotDifficultyLevel botDifficultyLevel;
    public BotPlayer(String name, int id, Symbol symbol, BotDifficultyLevel level) {
        super(name, id, symbol);
        this.botDifficultyLevel = level;
    }

    @Override
    public Move makeMove(Board board) {
        BotPlayingStrategy strategy = BotPlayingStrategyFactory.get(botDifficultyLevel);
        return strategy.suggestMove(board);
    }
}
