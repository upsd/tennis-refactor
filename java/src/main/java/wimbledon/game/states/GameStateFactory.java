package wimbledon.game.states;

import wimbledon.game.players.Player;
import wimbledon.game.translator.TennisTermTranslator;

public class GameStateFactory {

    private Player playerOne;
    private Player playerTwo;

    public GameStateFactory(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public GameState getState() {
        if (areDrawing())
        {
            return new DrawingState(playerOne.getScore(), new TennisTermTranslator());
        }
        if (areAtAdvantage())
        {
            return new AdvantageState(playerOne, playerTwo);
        }
        if (playerHasWon())
        {
            return new WonState(playerOne, playerTwo);
        }

        return new UnderFortyAndNotDrawingState(playerOne, playerTwo);
    }

    private boolean playerHasWon() {
        return playerOne.hasWonAgainst(playerTwo) || playerTwo.hasWonAgainst(playerOne);
    }

    private boolean areAtAdvantage() {
        return playerOne.hasAdvantageOver(playerTwo) || playerTwo.hasAdvantageOver(playerOne);
    }

    private boolean areDrawing() {
        return playerOne.isDrawingWith(playerTwo);
    }
}
