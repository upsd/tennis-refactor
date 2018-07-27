import java.util.HashMap;
import java.util.Map;

public class TennisScoreCalculator {
    private int m_score1;
    private int m_score2;
    private String player1Name;
    private String player2Name;
    private final Map tennisScoreLookup = new HashMap<Integer, String>();


    public TennisScoreCalculator(int m_score1, int m_score2, String player1Name, String player2Name) {
        this.m_score1 = m_score1;
        this.m_score2 = m_score2;
        this.player1Name = player1Name;
        this.player2Name = player2Name;

        populateTennisLookup();
    }

    public String calculate() {
        if (areDrawing())
        {
            if (m_score1 > 2) {
                return "Deuce";
            }

            return tennisScoreLookup.get(m_score1) + "-All";
        }
        else if (areAtAdvantageOrHaveWon())
        {
            return getScoreForAdvantageOrWin();
        }

        return tennisScoreLookup.get(m_score1) + "-" + tennisScoreLookup.get(m_score2);
    }

    private void populateTennisLookup() {
        tennisScoreLookup.put(0, "Love");
        tennisScoreLookup.put(1, "Fifteen");
        tennisScoreLookup.put(2, "Thirty");
        tennisScoreLookup.put(3, "Forty");
    }

    private String getScoreForAdvantageOrWin() {
        int scoreDifference = m_score1 - m_score2;

        if (scoreDifference == 1) return "Advantage " + player1Name;
        else if (scoreDifference == -1) return "Advantage " + player2Name;
        else if (scoreDifference >= 2) return "Win for " + player1Name;

        return "Win for " + player2Name;
    }

    private boolean areAtAdvantageOrHaveWon() {
        return m_score1 >= 4 || m_score2 >= 4;
    }

    private boolean areDrawing() {
        return m_score1 == m_score2;
    }
}
