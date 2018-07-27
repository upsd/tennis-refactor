package wimbledon.game.players;

public class Player {

    private static final int A_POINT = 1;
    private static final int WINNING_BY_ONE_POINT = 1;
    private static final int WINNING_BY_TWO_POINTS = 2;
    private static final int GAME = 4;
    private String name;
    private int score = 0;

    public Player(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    public void scorePoint() {
        score += A_POINT;
    }

    public int getScore() {
        return this.score;
    }

    public boolean isDrawingWith(Player opponent) {
        return this.getScore() == opponent.getScore();
    }

    public boolean hasWonAgainst(Player opponent) {
        return this.score >= GAME && getScoreDifference(opponent) >= WINNING_BY_TWO_POINTS;
    }

    public boolean hasAdvantageOver(Player opponent) {
        return this.score >= GAME && getScoreDifference(opponent) == WINNING_BY_ONE_POINT;
    }

    private int getScoreDifference(Player opponent) {
        return this.getScore() - opponent.getScore();
    }
}
