public class WonState implements GameState {

    private Player playerOne;
    private Player playerTwo;

    public WonState(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String getScore() {
        if (playerOne.hasWonAgainst(playerTwo)) {
            return "Win for " + playerOne.name();
        }

        return "Win for " + playerTwo.name();
    }
}
