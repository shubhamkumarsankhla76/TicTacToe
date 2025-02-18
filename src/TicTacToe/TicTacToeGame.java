package TicTacToe;

import TicTacToe.controller.GameController;
import TicTacToe.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame { // Mimicks our frontend

    private static GameController gameController = new GameController();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many human players are going to play?");
        int numHumanPlayers = scanner.nextInt();
        List<Player> players = new ArrayList<>();
        for(int i=0; i<numHumanPlayers;i++){
            System.out.println("Give player " + (i+1) + " name");
            String name = scanner.next();
            System.out.println("Give player " + (i+1) + " symbol");
            char symbol = scanner.next().charAt(0);
            // TODO check if we are getting unigue symbols
            players.add(new Player(name, symbol));
        }

        System.out.println("Is a bot going to play? (y/n)");
        char botReply = scanner.next().charAt(0);
        if (botReply == 'y' || botReply == 'Y'){
            System.out.println("Bot level? (h/l/m)");
            // TODO take level as input and then create obj of bot
            players.add(new Bot("BOT-1", 'B', BotLevel.LOW));
        }
        Game game;
        try {
            game = gameController.createGame(players);
        } catch (Exception e){
            System.out.println("Error while creating game: " + e.getMessage());
            return;
        }

        while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)){
            gameController.displayBoard(game);
            gameController.makeMove(game);
        }
        if(gameController.getGameStatus(game).equals(GameStatus.ENDED)){
            Player winnerPlayer = gameController.getCurrentPlayer(game);
            System.out.println(winnerPlayer.getName() + " has won!");
        }
        else if(gameController.getGameStatus(game).equals(GameStatus.DRAW)){
            System.out.println("Game has drawn!");
        }
        gameController.displayBoard(game);

    }
}