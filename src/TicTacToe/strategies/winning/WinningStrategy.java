package TicTacToe.strategies.winning;

import TicTacToe.models.Board;
import TicTacToe.models.Move;

public interface WinningStrategy {
    boolean checkIfWon(Board board, Move move);
}