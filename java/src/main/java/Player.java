public class Player {
    private String name;
    private int score = 0;

    public Player(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    public void scorePoint() {
        score += 1;
    }

    public int getScore() {
        return this.score;
    }

    public boolean isDrawingWith(Player otherPlayer) {
        return this.getScore() == otherPlayer.getScore();
    }

    public boolean hasWonAgainst(Player opponent) {
        return this.score >= 4 && getScoreDifference(opponent) >= 2;
    }

    public boolean hasAdvantageOver(Player opponent) {
        return this.score >= 4 && getScoreDifference(opponent) == 1;
    }

    private int getScoreDifference(Player opponent) {
        return this.getScore() - opponent.getScore();
    }
}
