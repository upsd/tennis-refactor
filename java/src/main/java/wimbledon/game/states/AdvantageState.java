package wimbledon.game.states;

import wimbledon.game.players.Player;

public class AdvantageState implements GameState {

    private static final String ADVANTAGE_MESSAGE = "Advantage ";
    private Player playerOne;
    private Player playerTwo;

    public AdvantageState(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String getScore() {
        if (playerOne.hasAdvantageOver(playerTwo)) {
            return ADVANTAGE_MESSAGE + playerOne.name();
        }

        return ADVANTAGE_MESSAGE + playerTwo.name();
    }
}
