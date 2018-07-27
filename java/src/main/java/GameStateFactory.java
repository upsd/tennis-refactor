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
            return new DrawingState(playerOne.getScore());
        }
        else if (areAtAdvantageOrHaveWon())
        {
            return new AdvantageOrWonState(playerOne, playerTwo);
        }

        return new UnderFortyAndNotDrawingState(playerOne, playerTwo);
    }

    private boolean areAtAdvantageOrHaveWon() {
        return playerOne.getScore() >= 4 || playerTwo.getScore() >= 4;
    }

    private boolean areDrawing() {
        return playerOne.getScore() == playerTwo.getScore();
    }
}
