public class TennisGame1 implements TennisGame {
    
    private final Player playerOne;
    private final Player playerTwo;
    private final TennisScoreCalculator tennisScoreCalculator;

    public TennisGame1(String player1Name, String player2Name) {
        playerOne = new Player(player1Name);
        playerTwo = new Player(player2Name);
        tennisScoreCalculator = new TennisScoreCalculator(playerOne, playerTwo);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(playerOne.name())) {
            playerOne.scorePoint();
        }
        else {
            playerTwo.scorePoint();
        }
    }

    public String getScore() {
        return tennisScoreCalculator.calculate();
    }
}
