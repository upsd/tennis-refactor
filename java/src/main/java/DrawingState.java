public class DrawingState implements GameState {

    private Player playerOne;
    private Player playerTwo;

    public DrawingState(Player playerOne, Player playerTwo) {

        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String getScore() {
        if (playerOne.getScore() > 2) {
            return "Deuce";
        }

        return new TennisTermTranslator().fromScore(playerOne.getScore()) + "-All";
    }
}
