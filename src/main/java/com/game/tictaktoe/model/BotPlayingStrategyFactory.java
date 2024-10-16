package com.game.tictaktoe.model;

import com.game.tictaktoe.strategies.BotPlayingStrategy;
import com.game.tictaktoe.strategies.EasyBotPlayingStrategy;
import com.game.tictaktoe.strategies.*;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy get(BotDifficultyLevel level){
        return switch (level) {
            case EASY -> new EasyBotPlayingStrategy();
            case HARD -> new HardBotPlayingStrategy();
            case MEDIUM -> new MediumBotPlayingStrategy();
        };
    }
}
