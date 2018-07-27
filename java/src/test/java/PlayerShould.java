import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wimbledon.game.players.Player;

import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayerShould {

    private Player player;
    private Player opponent;


    @BeforeEach
    public void setup() {
        player = new Player("mr sprinkles");
        opponent = new Player("mrs pumpernickel");
    }

    @Test
    public void score_a_point() {
        player.scorePoint();

        assertThat(player.getScore(), is(1));
    }

    @Test
    public void determine_if_they_have_beaten_opponent() {
        scorePointsFor(player, 4);

        boolean hasWon = player.hasWonAgainst(opponent);

        assertThat(hasWon, is(true));
    }

    @Test
    public void determine_if_they_have_advantage_over_opponent() {
        scorePointsFor(player, 5);
        scorePointsFor(opponent, 4);

        boolean hasAdvantage = player.hasAdvantageOver(opponent);

        assertThat(hasAdvantage, is(true));
    }

    private void scorePointsFor(Player playerToScore, int amount) {
        IntStream.range(1, amount + 1).forEach(i -> playerToScore.scorePoint());
    }
}
