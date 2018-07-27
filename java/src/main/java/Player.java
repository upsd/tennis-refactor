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
}
