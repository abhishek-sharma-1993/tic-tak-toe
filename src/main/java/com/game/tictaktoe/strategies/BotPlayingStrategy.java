package com.game.tictaktoe.strategies;

import com.game.tictaktoe.model.Board;
import com.game.tictaktoe.model.Move;

public interface BotPlayingStrategy {
    Move suggestMove(Board board);
}
