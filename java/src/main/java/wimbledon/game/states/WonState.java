package wimbledon.game.states;

import wimbledon.game.players.Player;

public class WonState implements GameState {

    private static final String WIN_MESSAGE = "Win for ";
    private Player playerOne;
    private Player playerTwo;

    public WonState(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String getScore() {
        if (playerOne.hasWonAgainst(playerTwo)) {
            return WIN_MESSAGE + playerOne.name();
        }

        return WIN_MESSAGE + playerTwo.name();
    }
}
