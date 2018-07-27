package wimbledon.game.translater;

import java.util.HashMap;
import java.util.Map;

public class TennisTermTranslator {

    private final Map tennisScoreLookup = new HashMap<Integer, String>();

    public TennisTermTranslator() {

        tennisScoreLookup.put(0, "Love");
        tennisScoreLookup.put(1, "Fifteen");
        tennisScoreLookup.put(2, "Thirty");
        tennisScoreLookup.put(3, "Forty");
    }

    public String fromScore(int score) {
        return tennisScoreLookup.get(score).toString();
    }
}
