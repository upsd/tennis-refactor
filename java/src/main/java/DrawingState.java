public class DrawingState implements GameState {

    private int score;

    public DrawingState(int score) {
        this.score = score;
    }

    public String getScore() {
        if (score > 2) {
            return "Deuce";
        }

        return new TennisTermTranslator().fromScore(score) + "-All";
    }
}
