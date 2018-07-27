import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TennisScoreCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "0, 0, Scott, Fred, Love-All",
            "1, 1, Scott, Fred, Fifteen-All",
            "2, 2, Scott, Fred, Thirty-All",
            "3, 3, Scott, Fred, Deuce",
            "4, 5, Scott, Fred, Advantage Fred",
            "5, 4, Scott, Fred, Advantage Scott",
            "6, 4, Scott, Fred, Win for Scott",
            "4, 6, Scott, Fred, Win for Fred",
            "1, 2, Scott, Fred, Fifteen-Thirty",
            "2, 1, Scott, Fred, Thirty-Fifteen",
            "1, 3, Scott, Fred, Fifteen-Forty",
            "3, 1, Scott, Fred, Forty-Fifteen",
            "2, 3, Scott, Fred, Thirty-Forty",
            "3, 2, Scott, Fred, Forty-Thirty",
    })
    public void display_score_for_a_draw(int playerOneScore,
                                                                 int playerTwoScore,
                                                                 String playerOneName,
                                                                 String playerTwoName,
                                                                 String expectedScore) {
        TennisScoreCalculator tennisScoreCalculator = new TennisScoreCalculator(
                playerOneScore,
                playerTwoScore,
                playerOneName,
                playerTwoName
        );

        String score = tennisScoreCalculator.calculate();

        assertThat(score, is(expectedScore));
    }
}