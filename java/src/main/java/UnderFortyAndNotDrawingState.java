public class UnderFortyAndNotDrawingState implements GameState {

    private Player playerOne;
    private Player playerTwo;

    public UnderFortyAndNotDrawingState(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String getScore() {
        TennisTermTranslator translator = new TennisTermTranslator();
        return translator.fromScore(playerOne.getScore()) + "-" + translator.fromScore(playerTwo.getScore());
    }
}
