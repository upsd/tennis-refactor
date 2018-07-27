package wimbledon.game.states;

import wimbledon.game.translator.TennisTermTranslator;

public class DrawingState implements GameState {

    private static final int THIRTY = 2;
    private int score;
    private final TennisTermTranslator translator;

    public DrawingState(int score, TennisTermTranslator translator) {
        this.score = score;
        this.translator = translator;
    }

    public String getScore() {
        if (score > THIRTY) {
            return "Deuce";
        }

        return translator.fromScore(score) + "-All";
    }
}
