package wimbledon.game.players;

public class Player {

    public static final int A_POINT = 1;
    public static final int WINNING_BY_ONE_POINT = 1;
    public static final int WINNING_BY_TWO_POINTS = 2;
    public static final int GAME = 4;
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

    public boolean isDrawingWith(Player otherPlayer) {
        return this.getScore() == otherPlayer.getScore();
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
