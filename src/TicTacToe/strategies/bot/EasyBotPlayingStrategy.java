package TicTacToe.strategies.bot;

import TicTacToe.models.*;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move makeMove(Board board, Player player) {
        Cell moveCell = null;
        outer: for (List<Cell> row : board.getCells()) {
            for (Cell cell : row) {
                if(cell.getCellState().equals(CellState.EMPTY)){
                    moveCell = cell;
                    break outer;
                }
            }
        }
        if(moveCell != null) {
            board.setPlayer(player, moveCell.getRow(), moveCell.getCol());
            return new Move(player, moveCell);
        }
        return null;
    }
}