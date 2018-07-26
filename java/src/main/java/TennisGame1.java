import java.util.HashMap;
import java.util.Map;

public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private Map tennisScoreLookup = new HashMap<Integer, String>();

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;

        tennisScoreLookup.put(0, "Love");
        tennisScoreLookup.put(1, "Fifteen");
        tennisScoreLookup.put(2, "Thirty");
        tennisScoreLookup.put(3, "Forty");
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        if (areDrawing())
        {
            switch (m_score1)
            {
                case 0:
                        score = tennisScoreLookup.get(m_score1) + "-All";
                    break;
                case 1:
                        score = tennisScoreLookup.get(m_score1) + "-All";
                    break;
                case 2:
                        score = tennisScoreLookup.get(m_score1) + "-All";
                    break;
                default:
                        score = "Deuce";
                    break;
                
            }
        }
        else if (areAtAdvantageOrHaveWon())
        {
            int minusResult = m_score1-m_score2;
            if (minusResult==1) score ="Advantage " + player1Name;
            else if (minusResult ==-1) score ="Advantage " + player2Name;
            else if (minusResult>=2) score = "Win for " + player1Name;
            else score ="Win for " + player2Name;
        }
        else
        {
            score += tennisScoreLookup.get(m_score1);
            score += "-";
            score += tennisScoreLookup.get(m_score2);

        }

        return score;
    }

    private boolean areAtAdvantageOrHaveWon() {
        return m_score1>=4 || m_score2>=4;
    }

    private boolean areDrawing() {
        return m_score1==m_score2;
    }
}
