public class AdvantageOrWonState implements GameState {

    private Player playerOne;
    private Player playerTwo;

    public AdvantageOrWonState(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String getScore() {
        int scoreDifference = playerOne.getScore() - playerTwo.getScore();

        if (scoreDifference == 1) return "Advantage " + playerOne.name();
        else if (scoreDifference == -1) return "Advantage " + playerTwo.name();
        else if (scoreDifference >= 2) return "Win for " + playerOne.name();

        return "Win for " + playerTwo.name();
    }
}
