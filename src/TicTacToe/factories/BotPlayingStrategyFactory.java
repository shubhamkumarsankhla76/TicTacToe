package TicTacToe.factories;

import TicTacToe.models.BotLevel;
import TicTacToe.strategies.bot.BotPlayingStrategy;
import TicTacToe.strategies.bot.EasyBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getStrategy(BotLevel level){
        switch (level){
            case LOW:
            case HIGH:
            case MEDIUM:
                return new EasyBotPlayingStrategy();
        }
        throw new UnsupportedOperationException("Unknown bot type");
    }
}