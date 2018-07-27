public class DrawingState implements GameState {

    private static final int THIRTY = 2;
    private int score;
    private final TennisTermTranslator translator;

    public DrawingState(int score) {
        this.score = score;
        translator = new TennisTermTranslator();
    }

    public String getScore() {
        if (score > THIRTY) {
            return "Deuce";
        }

        return translator.fromScore(score) + "-All";
    }
}
