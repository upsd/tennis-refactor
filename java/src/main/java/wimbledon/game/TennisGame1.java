package wimbledon.game;

import wimbledon.game.players.Player;
import wimbledon.game.states.GameState;
import wimbledon.game.states.GameStateFactory;

public class TennisGame1 implements TennisGame {
    
    private final Player playerOne;
    private final Player playerTwo;
    private final GameStateFactory gameStateFactory;

    public TennisGame1(String player1Name, String player2Name) {
        playerOne = new Player(player1Name);
        playerTwo = new Player(player2Name);
        gameStateFactory = new GameStateFactory(playerOne, playerTwo);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(playerOne.name())) {
            playerOne.scorePoint();
        }
        else {
            playerTwo.scorePoint();
        }
    }

    public String getScore() {
        GameState state = gameStateFactory.getState();
        return state.getScore();
    }
}
