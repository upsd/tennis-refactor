public class AdvantageState implements GameState {

    private Player playerOne;
    private Player playerTwo;

    public AdvantageState(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String getScore() {
        if (playerOne.hasAdvantageOver(playerTwo)) {
            return "Advantage " + playerOne.name();
        }

        return "Advantage " + playerTwo.name();
    }
}
