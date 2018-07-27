package wimbledon.game.states;

import wimbledon.game.players.Player;
import wimbledon.game.translator.TennisTermTranslator;

public class UnderFortyAndNotDrawingState implements GameState {

    private Player playerOne;
    private Player playerTwo;
    private final TennisTermTranslator translator;

    public UnderFortyAndNotDrawingState(Player playerOne, Player playerTwo, TennisTermTranslator translator) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.translator = translator;
    }

    public String getScore() {
        String playerOneScore = translator.fromScore(playerOne.getScore());
        String playerTwoScore = translator.fromScore(playerTwo.getScore());

        return String.format("%s-%s", playerOneScore, playerTwoScore);
    }
}
