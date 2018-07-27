import org.junit.jupiter.api.Test;
import wimbledon.game.players.Player;
import wimbledon.game.states.WonState;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WonStateShould {

    @Test
    public void get_score_when_player_one_has_won() {
        Player playerOne = mock(Player.class);
        WonState state = new WonState(playerOne, null);

        when(playerOne.hasWonAgainst(any())).thenReturn(true);
        when(playerOne.name()).thenReturn("reginald");

        String score = state.getScore();

        assertThat(score, is("Win for reginald"));
    }

    @Test
    public void get_score_when_player_two_has_won() {
        Player playerOne = mock(Player.class);
        Player playerTwo = mock(Player.class);
        WonState state = new WonState(playerOne, playerTwo);

        when(playerOne.hasWonAgainst(any())).thenReturn(false);
        when(playerTwo.name()).thenReturn("chris");

        String score = state.getScore();

        assertThat(score, is("Win for chris"));
    }
}
