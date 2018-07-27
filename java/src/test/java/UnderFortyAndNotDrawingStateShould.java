import org.junit.jupiter.api.Test;
import wimbledon.game.players.Player;
import wimbledon.game.states.UnderFortyAndNotDrawingState;
import wimbledon.game.translator.TennisTermTranslator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UnderFortyAndNotDrawingStateShould {

    @Test
    public void get_score_when_players_are_under_forty_points_and_not_drawing() {
        Player playerOne = mock(Player.class);
        Player playerTwo = mock(Player.class);
        TennisTermTranslator translator = mock(TennisTermTranslator.class);
        UnderFortyAndNotDrawingState state = new UnderFortyAndNotDrawingState(playerOne, playerTwo, translator);

        when(translator.fromScore(any(Integer.class))).thenReturn("Love", "Fifteen");
        when(playerOne.getScore()).thenReturn(0);
        when(playerTwo.getScore()).thenReturn(1);

        String score = state.getScore();

        assertThat(score, is("Love-Fifteen"));
    }
}
