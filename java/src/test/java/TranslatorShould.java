import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import wimbledon.game.translator.TennisTermTranslator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TranslatorShould {

    @ParameterizedTest
    @CsvSource({
            "0, Love",
            "1, Fifteen",
            "2, Thirty",
            "3, Forty",
    })
    public void translate_points_to_tennis_terms(int score, String expectedTerm) {
        TennisTermTranslator translator = new TennisTermTranslator();

        String term = translator.fromScore(score);

        assertThat(term, is(expectedTerm));
    }
}