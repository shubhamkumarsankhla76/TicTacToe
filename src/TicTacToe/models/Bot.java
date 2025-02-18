package TicTacToe.models;

import TicTacToe.factories.BotPlayingStrategyFactory;
import TicTacToe.strategies.bot.BotPlayingStrategy;

public class Bot extends Player{
    private BotLevel level;
    private BotPlayingStrategy strategy;

    public Bot(String name, Character symbol, BotLevel level) {
        super(name, symbol);
        this.level = level;
        this.strategy = BotPlayingStrategyFactory.getStrategy(level);
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println(getName() + "'s turn");
        Move move = strategy.makeMove(board, this);
        System.out.println("Bot is making a move on " + move.getCell().getRow() + " " + move.getCell().getCol());
        return move;
    }
}