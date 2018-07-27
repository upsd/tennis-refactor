import java.util.HashMap;
import java.util.Map;

public class TennisScoreCalculator {

    private final Map tennisScoreLookup = new HashMap<Integer, String>();
    private Player playerOne;
    private Player playerTwo;

    public TennisScoreCalculator(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;

        populateTennisLookup();
    }

    public String calculate() {
        if (areDrawing())
        {
            if (playerOne.getScore() > 2) {
                return "Deuce";
            }

            return tennisScoreLookup.get(playerOne.getScore()) + "-All";
        }
        else if (areAtAdvantageOrHaveWon())
        {
            return getScoreForAdvantageOrWin();
        }

        return tennisScoreLookup.get(playerOne.getScore()) + "-" + tennisScoreLookup.get(playerTwo.getScore());
    }

    private void populateTennisLookup() {
        tennisScoreLookup.put(0, "Love");
        tennisScoreLookup.put(1, "Fifteen");
        tennisScoreLookup.put(2, "Thirty");
        tennisScoreLookup.put(3, "Forty");
    }

    private String getScoreForAdvantageOrWin() {
        int scoreDifference = playerOne.getScore() - playerTwo.getScore();

        if (scoreDifference == 1) return "Advantage " + playerOne.name();
        else if (scoreDifference == -1) return "Advantage " + playerTwo.name();
        else if (scoreDifference >= 2) return "Win for " + playerOne.name();

        return "Win for " + playerTwo.name();
    }

    private boolean areAtAdvantageOrHaveWon() {
        return playerOne.getScore() >= 4 || playerTwo.getScore() >= 4;
    }

    private boolean areDrawing() {
        return playerOne.getScore() == playerTwo.getScore();
    }
}
