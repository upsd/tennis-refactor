public class DrawingState implements GameState {

    private int score;
    private final TennisTermTranslator translator;

    public DrawingState(int score) {
        this.score = score;
        translator = new TennisTermTranslator();
    }

    public String getScore() {
        if (score > 2) {
            return "Deuce";
        }

        return translator.fromScore(score) + "-All";
    }
}
