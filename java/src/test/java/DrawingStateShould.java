import org.junit.jupiter.api.Test;
import wimbledon.game.states.DrawingState;
import wimbledon.game.translator.TennisTermTranslator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DrawingStateShould {

    @Test
    public void get_score_when_game_is_at_deuce() {
        int DEUCE = 3;
        DrawingState state = new DrawingState(DEUCE, null);

        String score = state.getScore();

        assertThat(score, is("Deuce"));
    }

    @Test
    public void get_score_when_game_is_not_at_deuce() {
        TennisTermTranslator translator = mock(TennisTermTranslator.class);
        DrawingState state = new DrawingState(0, translator);

        when(translator.fromScore(0)).thenReturn("Love");

        String score = state.getScore();

        assertThat(score, is("Love-All"));
    }
}
