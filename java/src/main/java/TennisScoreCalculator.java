public class TennisScoreCalculator {

    private GameStateFactory gameStateFactory;

    public TennisScoreCalculator(Player playerOne, Player playerTwo) {
        gameStateFactory = new GameStateFactory(playerOne, playerTwo);
    }

    public String calculate() {
        GameState state = gameStateFactory.getState();
        return state.getScore();
    }
}
