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