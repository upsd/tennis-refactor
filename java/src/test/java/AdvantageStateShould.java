import org.junit.jupiter.api.Test;
import wimbledon.game.players.Player;
import wimbledon.game.states.AdvantageState;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdvantageStateShould {

    @Test
    public void get_score_for_player_one_when_they_have_advantage() {
        Player playerOne = mock(Player.class);
        AdvantageState state = new AdvantageState(playerOne, null);

        when(playerOne.hasAdvantageOver(any())).thenReturn(true);
        when(playerOne.name()).thenReturn("reginald");

        String score = state.getScore();

        assertThat(score, is("Advantage reginald"));
    }

    @Test
    public void get_score_for_player_two_when_they_have_advantage() {
        Player playerOne = mock(Player.class);
        Player playerTwo = mock(Player.class);
        AdvantageState state = new AdvantageState(playerOne, playerTwo);

        when(playerOne.hasAdvantageOver(any())).thenReturn(false);
        when(playerTwo.name()).thenReturn("chris");

        String score = state.getScore();

        assertThat(score, is("Advantage chris"));
    }
}
